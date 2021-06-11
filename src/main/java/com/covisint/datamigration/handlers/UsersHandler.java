package com.covisint.datamigration.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.covisint.datamigration.core.domain.MigrateUsers;
import com.covisint.datamigration.core.domain.Users;
import com.covisint.datamigration.core.dto.UsersDTO;
import com.covisint.datamigration.rest.client.ApiClient;
import com.covisint.datamigration.service.UsersService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("usersHandler")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UsersHandler {
	
	private static Logger log = LoggerFactory.getLogger(UsersHandler.class);
	
	@Autowired
	UsersService usersService;	

	@Autowired
	ApiClient apiClient;

	@Value("${realm.id}")
	String realmId;

	@Value("${password.policy.id.for.dev}")
	String passwordPolicyForDev;

	@Value("${password.policy.id.for.qa}")
	String passwordPolicyForQA;

	@Value("${authentication.policy.id.for.dev}")
	String authenticationPolicyForDev;

	@Value("${authentication.policy.id.for.qa}")
	String authenticationPolicyForQA;

	private String filePath;
	private String dataFetchSource;

	Map<String, String> attributesMap = new LinkedHashMap<>();	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void handleDatamigration() {
		pushUsersFromFile(filePath);	

	}
	
	
	public void pushUsersFromFile(String filePath){
		
		Workbook workbook = null;
		List<Integer> userIdList = new ArrayList<>();
				
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet("Users");
			Iterator<Row> rows = sheet.iterator();
			
			while (rows.hasNext()) {
				  Row currentRow = rows.next();

				  Iterator<Cell> cellsInRow = currentRow.iterator();

				  while (cellsInRow.hasNext()) {
				     Cell currentCell = cellsInRow.next();

				     Integer userId = (int) currentCell.getNumericCellValue();
				     userIdList.add(userId);
				  }
			}
			workbook.close();
		}catch (Exception e){
			
		}
		
		//System.out.println("User ID List:"+ userIdList);
		
		userIdList.forEach(userId -> {
			try {
				System.out.println("============================================================================================");
				
				Users user = usersService.getUserById(userId);
				UsersDTO userDTO = usersService.buildUsersDTO(user);
				Gson gson = new GsonBuilder().create();
				String jsonString = gson.toJson(userDTO);
				//System.out.println("User DTO: "+jsonString);
				
				Map<String,String> params = new HashMap<>();
				params.put("username", user.getSsoUserId());
				params.put("email", user.getEmail());
				
				
				
				Boolean userExists = false;
				ResponseEntity<String> userRespEntity = usersService.searchUser(params);
				String jsonRespUser = userRespEntity.getBody();
				//System.out.println("Search User API RESPONSE: " + jsonRespUser);
				//System.out.println("Search User API RESPONSE JSON Length: " + jsonRespUser.length());
				if(jsonRespUser != null && jsonRespUser.length() > 4) {
					 userExists = true;					 
					 System.out.println("UserID: "+userId+" with username: "+user.getSsoUserId()+" already exists in nextgen ");
					//Save the data into migrate_users_dev for dev and migrate_users for rest of the environment
					 MigrateUsers migrateUsersObj = usersService.getMigrateUsersDTO(jsonRespUser, user, userId);
					 usersService.saveMigrateUsers(migrateUsersObj);
									
				}else {
					ResponseEntity<String> respEntity = usersService.personsRegistration(jsonString);
					String jsonResponseNewUser = respEntity.getBody();
					System.out.println("UserID: "+userId+" with username: "+user.getSsoUserId()+" is registered ");
					System.out.println(jsonResponseNewUser);
					
					//Save the data into migrate_users_dev for dev and migrate_users for rest of the environment
					MigrateUsers migrateUsersObj = usersService.getMigrateNewUsersDTO(jsonResponseNewUser, user, userId);
					usersService.saveMigrateUsers(migrateUsersObj);
					
				}
				System.out.println("==================================================================================");
				 
			}catch(Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
			
		});
		
	}	

	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDataFetchSource() {
		return dataFetchSource;
	}

	public void setDataFetchSource(String dataFetchSource) {
		this.dataFetchSource = dataFetchSource;
	}

}
