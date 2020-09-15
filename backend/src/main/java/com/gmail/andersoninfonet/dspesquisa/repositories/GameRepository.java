package com.gmail.andersoninfonet.dspesquisa.repositories;

import com.gmail.andersoninfonet.dspesquisa.entities.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}