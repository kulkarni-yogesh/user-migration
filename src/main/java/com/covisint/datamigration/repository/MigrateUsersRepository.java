package com.covisint.datamigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covisint.datamigration.core.domain.MigrateUsers;

@Repository("migrateUsersRepository")
public interface MigrateUsersRepository extends JpaRepository<MigrateUsers, Integer> {
	
	@Query(value = "select * from MIGRATE_USERS where legacy_user_id = ?1", nativeQuery = true)
	MigrateUsers findByLegacyUserId(String legacyUserId);
	
	@Query(value = "select * from MIGRATE_USERS where legacy_user_id = ?1 and nextgen_user_id = ?2", nativeQuery = true)
	MigrateUsers findByLegacyUserIdAndNextgenUserId(String legacyUserId, String nextgenUserId);

}
