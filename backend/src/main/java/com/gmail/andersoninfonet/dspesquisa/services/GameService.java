package com.gmail.andersoninfonet.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import com.gmail.andersoninfonet.dspesquisa.dto.GameDTO;
import com.gmail.andersoninfonet.dspesquisa.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findALL() {
        return gameRepository.findAll().stream().map(g -> new GameDTO(g)).collect(Collectors.toList());
    }
}