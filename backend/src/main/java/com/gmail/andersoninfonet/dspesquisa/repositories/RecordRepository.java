package com.gmail.andersoninfonet.dspesquisa.repositories;

import java.time.Instant;

import com.gmail.andersoninfonet.dspesquisa.entities.Record;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT obj FROM Record obj WHERE " + 
            "(coalesce(:minDate, null) IS NULL OR obj.moment >= :minDate) AND " + 
            "(coalesce(:maxDate, null) IS NULL OR obj.moment <= :maxDate)")
	Page<Record> findByMoment(Instant minDate, Instant maxDate, Pageable pageable);
    
}