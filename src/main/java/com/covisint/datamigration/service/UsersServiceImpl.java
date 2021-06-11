package com.covisint.datamigration.service;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covisint.datamigration.core.domain.MigrateOrganizations;
import com.covisint.datamigration.core.domain.MigrateUsers;
import com.covisint.datamigration.core.domain.Users;
import com.covisint.datamigration.core.dto.Address;
import com.covisint.datamigration.core.dto.NameDTO;
import com.covisint.datamigration.core.dto.OrganizationRequestDTO;
import com.covisint.datamigration.core.dto.PasswordAccountDTO;
import com.covisint.datamigration.core.dto.PersonDTO;
import com.covisint.datamigration.core.dto.QuestionsDTO;
import com.covisint.datamigration.core.dto.ReferenceDTO;
import com.covisint.datamigration.core.dto.SecurityQuestionAccountDTO;
import com.covisint.datamigration.core.dto.UsersDTO;
import com.covisint.datamigration.core.dto.phone;
import com.covisint.datamigration.enums.PhoneType;
import com.covisint.datamigration.repository.MigrateOrganizationsRepository;
import com.covisint.datamigration.repository.MigrateUsersRepository;
import com.covisint.datamigration.repository.UsersRepository;
import com.covisint.datamigration.rest.client.ApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service("Users")
public class UsersServiceImpl implements UsersService {

	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ApiClient apiClient;
	
	@Value("${client.id}")
	String clientId;

	@Value("${client.secret}")
	String clientSecret;
	
	@Value("${apigee.url}")
	String apigeeUrl;
	
	@Value("${oauth.url}")
	String oauthUrl;
	
	@Value("${person.url}")
	String personUrl;
	
	
	@Value("${realm.id}")
	String realmId;
	
	@Autowired
	MigrateUsersRepository migrateUsersRepo;
	
	@Autowired
	MigrateOrganizationsRepository migrateOrgRepo;
	
	@Transactional(readOnly = true)
	public Slice<Users> getAllUsersByCountryCode(String countryCode, Pageable pageable) {

		Slice<Users> orgSlice = usersRepository.getAllUsersByCountryCode(countryCode, pageable);

		return orgSlice;
	}
	
	@Transactional(readOnly = true)
	public Users getUserById(Integer userId) {
		
		Optional<Users> user = usersRepository.findById(userId);
		return user.get();
	}

	@Override
	public ResponseEntity<String> personsRegistration(String userPayload) {

		ResponseEntity<String> respEntity = null;
		String tokenUri = apigeeUrl + oauthUrl;
		String uri = apigeeUrl + personUrl+ "/registration";

		try {
			String token = apiClient.getToken(tokenUri, clientId, clientSecret);
			//System.out.println(token);
			//System.out.println("PersonsRegistration API URL: "+uri);
			//System.out.println("PersonsRegistration User Payload: "+userPayload);
			
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Accept", "application/vnd.com.covisint.platform.person.password.account.v1+json");
			headers.put("solutionInstanceId", "a272c9de-e051-48ac-a8bd-93a177d77297");
			headers.put("Content-Type", "application/vnd.com.covisint.platform.person.password.account.v1+json");
			headers.put("Authorization", "Bearer " + token);
			
			respEntity = apiClient.postOperation(uri, userPayload, headers, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respEntity;
	}
	
	@Override
	public ResponseEntity<String> searchUser(Map<String, String> params) {
		ResponseEntity<String> respEntity = null;
		String tokenUri = apigeeUrl + oauthUrl;
		String uri = apigeeUrl + personUrl;
		//System.out.println("Token URL: "+tokenUri);
		//System.out.println("API URL: "+uri);
		try {
			String token = apiClient.getToken(tokenUri, clientId, clientSecret);
			//System.out.println("Access Token: "+token);
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Accept", "application/vnd.com.covisint.platform.person.v1+json");
			headers.put("Content-Type", "application/vnd.com.covisint.platform.person.v1+json");
			headers.put("Authorization", "Bearer " + token);			
			
			String newUri = appendUri(uri, params);
			//System.out.println("API URL: "+newUri.replaceAll("%20", " "));
			respEntity = apiClient.getOperation(newUri.replaceAll("%20", " "), headers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respEntity;
	}
	
	private String appendUri(String uri, Map<String, String> parameters) throws URISyntaxException {

		 URI oldUri = new URI(uri);
		    StringBuilder queries = new StringBuilder();

		    for(Map.Entry<String, String> query: parameters.entrySet()) {
		        queries.append( "&" + query.getKey()+"="+query.getValue());
		    }

		    String newQuery = oldUri.getQuery();
		    if (newQuery == null) {
		        newQuery = queries.substring(1);
		    } else {
		        newQuery += queries.toString();
		    }

		    URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
		            oldUri.getPath(), newQuery, oldUri.getFragment());
		    
		    return newUri.toString();
	}
	
	@Override
	public MigrateUsers getMigrateUsersDTO(String jsonRespUser, Users user, Integer userId) {		
		
		JsonArray jsonArray = new Gson().fromJson(jsonRespUser, JsonArray.class);
		
		JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
		String userName = jsonObject.get("username").getAsString();
		String nextgenUserId = jsonObject.get("id").getAsString();
		
		JsonObject jsonOrgObject = jsonObject.get("organization").getAsJsonObject();
		String nextgenBelongsToOrgId = jsonOrgObject.get("id").getAsString();
		System.out.println("Testing nextgenBelongsToOrgId : "+nextgenBelongsToOrgId);
		
		MigrateUsers migrateUsers = new MigrateUsers();
		migrateUsers.setLegacyUserId(userId+"");
		migrateUsers.setUserName(userName);
		migrateUsers.setNextgenUserId(nextgenUserId);
		migrateUsers.setLegacyBelongsToOrgId(user.getOrgId()+"");
		migrateUsers.setNextgenBelongsToOrgId(nextgenBelongsToOrgId);
		
		
		return migrateUsers;

	}
	
	@Override
	public MigrateUsers getMigrateNewUsersDTO(String jsonRespUser, Users user, Integer userId) {		
		
		JsonObject jsonObject = new Gson().fromJson(jsonRespUser, JsonObject.class);
		JsonObject jsonPersonObject = jsonObject.get("person").getAsJsonObject();		
		String nextgenUserId = jsonPersonObject.get("id").getAsString();
		
		JsonObject jsonOrgObject = jsonPersonObject.get("organization").getAsJsonObject();
		String nextgenBelongsToOrgId = jsonOrgObject.get("id").getAsString();
		System.out.println("Testing nextgenBelongsToOrgId : "+nextgenBelongsToOrgId);
		
		JsonObject jsonUsernameObject = jsonObject.get("passwordAccount").getAsJsonObject();
		String userName = jsonUsernameObject.get("username").getAsString();
		
		MigrateUsers migrateUsers = new MigrateUsers();
		migrateUsers.setLegacyUserId(userId+"");
		migrateUsers.setUserName(userName);
		migrateUsers.setNextgenUserId(nextgenUserId);
		migrateUsers.setLegacyBelongsToOrgId(user.getOrgId()+"");
		migrateUsers.setNextgenBelongsToOrgId(nextgenBelongsToOrgId);
		
		
		return migrateUsers;

	}
	
	@Transactional(readOnly = false)
	public void saveMigrateUsers(MigrateUsers migrateUsers) {
		migrateUsersRepo.save(migrateUsers);
	}
	
	
	public UsersDTO buildUsersDTO(Users user) {
		UsersDTO userDTO = new UsersDTO();
		
		userDTO.setPerson(getPersonDTO(user));
		userDTO.setPasswordAccount(getPasswordAccountDTO(user));
		userDTO.setCreator("[PP-AUTO-DEV]PP-AUTO-DEV_ADMIN");
		userDTO.setCreation(0);
		//userDTO.setCreation(1457239467000);		
		userDTO.setRealm(realmId);
		userDTO.setExpiration(0);
		userDTO.setLocked("false");
		userDTO.setUnlockInstant(0);
		userDTO.setSecurityQuestionAccount(getSecurityQuestionAccountDTO(user));
		
		return userDTO;
	}
	
	private PersonDTO getPersonDTO(Users user) {
		
		PersonDTO personDTO = new PersonDTO();
		personDTO.setRealm(realmId);
		personDTO.setStatus("active");
		personDTO.setCurrency("USD");
		//personDTO.setCurrency(user.getCurrency());
		personDTO.setName(getUserName(user));
		personDTO.setAddresses(getAddresses(user));
//		personDTO.setLanguage(user.getLanguage());
		personDTO.setLanguage("en");
//		personDTO.setTimezone(String.valueOf(user.getTimeZoneId()));
		personDTO.setTimezone("CST6CDT");
		personDTO.setPhones(getPhones(user));
		personDTO.setEmail(user.getEmail());
		personDTO.setOrganization(getOrganization(user));
		
		return personDTO;
	}
	
	NameDTO getUserName(Users user) {
		
		NameDTO nameDTO = new NameDTO();
		
		nameDTO.setPrefix("Mr.");
		nameDTO.setGiven(user.getFirstName());
		nameDTO.setSurname(user.getLastName());
		
		return nameDTO;
	}
	
	private List<Address> getAddresses(Users users) {
		
		List<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		List<String> streets = new ArrayList<String>();
		
		address.setCountry(users.getCountryCode());
		address.setState(users.getStateProvince());
		address.setPostal(users.getPostalCode());
		streets.add(users.getAddress1());
		address.setStreets(streets);
		address.setCity(users.getCity());
		
		addresses.add(address);
		
		return addresses;
	}
	
	private List<phone> getPhones(Users user) {
		
		List<phone> phones = new ArrayList<phone>();
		phone ph1 = new phone();
		
		ph1.setType(PhoneType.main);
		ph1.setNumber(user.getPhone());
		
		phones.add(ph1);
		phone ph2 = new phone();
		
		ph2.setType(PhoneType.mobile);
		ph2.setNumber(user.getPhone());
		
		phones.add(ph2);
		
		return phones;
		
	}
	
	private ReferenceDTO getOrganization(Users user) {
		
		List<MigrateOrganizations> migrOrgList = migrateOrgRepo.findByLegacyOgId(Long.valueOf(user.getOrgId()));
		String gGblCovOrgId = null;
		
		if(!CollectionUtils.isEmpty(migrOrgList)) {
			gGblCovOrgId = migrOrgList.get(0).getGblCovOrgId();
		}
		System.out.println("LEGACY_ORG_ID: "+user.getOrgId()+"---> GBL_COV_ORG_ID: "+gGblCovOrgId);
		ReferenceDTO org = new ReferenceDTO();		
		//org.setId(gGblCovOrgId != null ? gGblCovOrgId : "OPP-AUTO-DEV9734589214");
		org.setId(gGblCovOrgId);
		org.setType("organization");
		org.setRealm(realmId);
		
		return org;
	}
	
	private PasswordAccountDTO getPasswordAccountDTO(Users user) {
		
		PasswordAccountDTO passAccDTO = new PasswordAccountDTO();
		//passAccDTO.setUsername(user.getFirstName());
		passAccDTO.setUsername(user.getSsoUserId());
		passAccDTO.setPassword("test1234");
		passAccDTO.setPasswordPolicy(getPwdPolicy());
		passAccDTO.setAuthenticationPolicy(getAuthenticationPolicy());
		
		return passAccDTO;
	}
	
	public ReferenceDTO getPwdPolicy() {
		
		ReferenceDTO pwdPolicy = new ReferenceDTO();
		pwdPolicy.setId("ba7427ab-a5aa-423f-9030-5a9a99b6c876");
		pwdPolicy.setType("passwordPolicy");
		pwdPolicy.setRealm(realmId);
		
		return pwdPolicy;
	}
	
	public ReferenceDTO getAuthenticationPolicy() {
		
		ReferenceDTO authenticationPolicy = new ReferenceDTO(); 
		authenticationPolicy.setId("1916964d-069b-4b67-956d-d371a78f2875");
		authenticationPolicy.setType("authenticationPolicy");
		authenticationPolicy.setRealm(realmId);
		
		return authenticationPolicy;
	}
	
	public SecurityQuestionAccountDTO getSecurityQuestionAccountDTO(Users user) {
		
		SecurityQuestionAccountDTO secQueAccDTO = new SecurityQuestionAccountDTO();
		secQueAccDTO.setCreator("[PP-AUTO-DEV]PP-AUTO-DEV_ADMIN");
		secQueAccDTO.setCreation(0);
		secQueAccDTO.setRealm(realmId);
		List<QuestionsDTO> questionDTO = getQuestionsDTO(user);
		secQueAccDTO.setQuestions(questionDTO);
		
		return secQueAccDTO;
	}
	
	public List<QuestionsDTO> getQuestionsDTO(Users user) {
		
		List<QuestionsDTO> questionDTOList = new ArrayList<>();
		
		QuestionsDTO questionDTO1 = new QuestionsDTO();
		questionDTO1.setQuestion(getQuestion1(user));
//		questionDTO1.setAnswer(user.getFixedQuestion1Answer());
		questionDTO1.setAnswer("challengeanswer1");
		questionDTO1.setIndex(1);
		
		QuestionsDTO questionDTO2 = new QuestionsDTO();
		questionDTO2.setQuestion(getQuestion2(user));
//		questionDTO2.setAnswer(user.getFixedQuestion2Answer());
		questionDTO2.setAnswer("challengeanswer2");
		questionDTO2.setIndex(2);
		
		questionDTOList.add(questionDTO1);
		questionDTOList.add(questionDTO2);
		
		return questionDTOList;
	}
	
	public ReferenceDTO getQuestion1(Users user) {
		ReferenceDTO question = new ReferenceDTO();
		
//		question.setId(String.valueOf(user.getFixedQuestion1Id()));
		question.setId(realmId+":0");
		question.setType("question");
		question.setRealm(realmId);
		
		return question;
	}

	public ReferenceDTO getQuestion2(Users user) {
		ReferenceDTO question = new ReferenceDTO();
		
//		question.setId(String.valueOf(user.getFixedQuestion2Id()));
		question.setId(realmId+":1");
		question.setType("question");
		question.setRealm(realmId);
		
		return question;
	}
	
	public OrganizationRequestDTO buildRequestDTO(MigrateUsers user) {
		
		OrganizationRequestDTO reqDTO = new OrganizationRequestDTO();
		
		reqDTO.setRegistrant(getRegistrant(user));
		reqDTO.setOrganization(getOrgForReq(user));
		reqDTO.setJustification("testing");
		
		return reqDTO;
	}
	
	public ReferenceDTO getRegistrant(MigrateUsers user) {
		
		ReferenceDTO refDTO = new ReferenceDTO();
		refDTO.setId(user.getNextgenUserId());
//		refDTO.setId("4375389642CD41A2BC8B849E41996756");
		refDTO.setType("person");
		
		return refDTO;
	}
	
	public ReferenceDTO getOrgForReq(MigrateUsers user) {
		
		ReferenceDTO refDTO = new ReferenceDTO();
		String orgName = "";//migrateOrgRepo.getOrgNameByLegacyOrgIdAndNextgenOrgId(user.getLegacyBelongsToOrgId(), user.getNextgenBelongsToOrgId());
		
		refDTO.setId(orgName);
//		refDTO.setId("DMTESTORG_002");
		refDTO.setType("organization");
		
		return refDTO;
	}
	
	public MigrateUsers getMigrateUsers(String userId, String nextGenUserId) {
		
		MigrateUsers migrateUser = migrateUsersRepo.findByLegacyUserIdAndNextgenUserId(userId, nextGenUserId);
		
		return migrateUser;
	}
	
	public MigrateUsers getMigrateUsersByLegacyUserId(String userId) {
		
		MigrateUsers migrateUser = migrateUsersRepo.findByLegacyUserId(userId);
		
		return migrateUser;
	}
	
	
	
	
	
	
}
