package com.covisint.datamigration.repository;

import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_READONLY;
import javax.persistence.QueryHint;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.covisint.datamigration.core.domain.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	 @QueryHints(value = {
	            @QueryHint(name = HINT_FETCH_SIZE, value = "100"),
	            @QueryHint(name = HINT_CACHEABLE, value = "false"),
	            @QueryHint(name = HINT_READONLY, value = "true")
	    })
	    @Query("select u from Users u where u.countryCode=:CountryCode")
	 Slice<Users> getAllUsersByCountryCode(@Param("CountryCode") String countryCode, Pageable pageable);

}
