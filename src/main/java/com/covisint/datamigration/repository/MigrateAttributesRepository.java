package com.covisint.datamigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.covisint.datamigration.core.domain.MigrateAttributes;

@Repository("migrateAttributesRepository")
public interface MigrateAttributesRepository extends JpaRepository<MigrateAttributes, Long>{

}
