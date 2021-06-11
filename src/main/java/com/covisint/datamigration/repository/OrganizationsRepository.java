package com.covisint.datamigration.repository;

import com.covisint.datamigration.core.domain.Organizations;
import javax.persistence.QueryHint;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;
import static org.hibernate.jpa.QueryHints.HINT_READONLY;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("organizationsRepository")
public interface OrganizationsRepository extends JpaRepository<Organizations, Long>{
	 @QueryHints(value = {
	            @QueryHint(name = HINT_FETCH_SIZE, value = "100"),
	            @QueryHint(name = HINT_CACHEABLE, value = "false"),
	            @QueryHint(name = HINT_READONLY, value = "true")
	    })
	    @Query("select o from Organizations o where o.countryCode=:CountryCode")
	    //Stream<Organizations> getAll(@Param("CountryCode") String CountryCode);
	 Slice<Organizations> getAll(@Param("CountryCode") String CountryCode,  Pageable pageable);
}

