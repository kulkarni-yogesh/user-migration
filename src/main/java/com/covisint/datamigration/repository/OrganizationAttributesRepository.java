package com.covisint.datamigration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.covisint.datamigration.core.domain.OrganizationAttributes;

@Repository("organizationAttributesRepository")
public interface OrganizationAttributesRepository extends JpaRepository<OrganizationAttributes, Long>{
	
	/*
	 * @Query("SELECT a.attrId, a.name, oa.attrValue FROM OrganizationAttributes oa, Attributes a where oa.orgId = :orgId "
	 * + "and oa.attrId = a.id")
	 */
	@Query(value = "SELECT A.ATTRIBUTE_ID, A.NAME, OA.ATTRIBUTE_VALUE FROM ORG_ATTRIBUTES OA, ATTRIBUTES A WHERE OA.ORGANIZATION_ID = ?1 AND OA.ATTRIBUTE_ID=A.ATTRIBUTE_ID",nativeQuery = true)
    List<Object[]> getIdAndAttrId(Long orgId);

}
