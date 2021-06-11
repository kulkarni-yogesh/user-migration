package com.covisint.datamigration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.covisint.datamigration.handlers.UsersHandler;

@SpringBootApplication
@EntityScan(basePackages={"com.covisint.datamigration.**.domain","com.covisint.datamigration.**.dto"})
@ComponentScan(basePackages={"com.covisint.datamigration**"})
public class UserMigrationApplication implements CommandLineRunner{

	private static Logger log = LoggerFactory.getLogger(UserMigrationApplication.class);	
	
	@Autowired
	UsersHandler usersHandler;
	
	public static void main(String[] args) {
		
		SpringApplication.run(UserMigrationApplication.class, args);	
		
	}
	
	@Override
    public void run(String... args) {
		
		String param1 = null;
		String filePath = null;
		
		if(args.length == 0) {
			log.info("Please enter proper args to migrate..");
			return;
		}
		
		if(args.length == 2) {
			filePath = args[1];
		}
		
		param1 = args[0];
		System.out.println(param1);
		System.out.println(filePath);
		usersHandler.setDataFetchSource(param1);
		usersHandler.setFilePath(filePath);
		
		usersHandler.handleDatamigration();
	}
		
	/*
	 * private DatamigrationHandlers getHandler(String jobName) {
	 * DatamigrationHandlers handler = null; if(jobName.equals("organizations")) {
	 * handler =
	 * dataMigrFactory.findHandler(DataMigrationHandlerNames.OrganizationsHandler);
	 * } else if (jobName.equals("users")) { handler =
	 * dataMigrFactory.findHandler(DataMigrationHandlerNames.UsersHandler); }
	 * 
	 * return handler; }
	 */

}
