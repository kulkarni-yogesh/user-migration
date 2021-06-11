package com.covisint.datamigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covisint.datamigration.core.domain.MigrateOrganizations;


@Repository("migrateOrganizationsRepository")
public interface MigrateOrganizationsRepository extends JpaRepository<MigrateOrganizations, Long> {
	
	MigrateOrganizations findByJobId(String jobId);
	
	List<MigrateOrganizations> findByLegacyOgId(Long legacyOgId);

}
