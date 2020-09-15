package com.gmail.andersoninfonet.dspesquisa.repositories;

import com.gmail.andersoninfonet.dspesquisa.entities.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    
}