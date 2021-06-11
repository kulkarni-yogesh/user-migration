package com.covisint.datamigration.service;


import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;

import com.covisint.datamigration.core.domain.MigrateUsers;
import com.covisint.datamigration.core.domain.Users;
import com.covisint.datamigration.core.dto.OrganizationRequestDTO;
import com.covisint.datamigration.core.dto.UsersDTO;

public interface UsersService {

	Slice<Users> getAllUsersByCountryCode(String countryCode, Pageable pageable);
	ResponseEntity<String> personsRegistration(String userPayload);
	public ResponseEntity<String> searchUser(Map<String, String> params);
	UsersDTO buildUsersDTO(Users users);
	Users getUserById(Integer userId);
	OrganizationRequestDTO buildRequestDTO(MigrateUsers user);
	MigrateUsers getMigrateUsers(String userId, String nextGenUserId);
	MigrateUsers getMigrateUsersByLegacyUserId(String userId);
	MigrateUsers getMigrateUsersDTO(String jsonRespUser, Users user, Integer userId);
	MigrateUsers getMigrateNewUsersDTO(String jsonRespUser, Users user, Integer userId);
	void saveMigrateUsers(MigrateUsers migrateUsers);
}
