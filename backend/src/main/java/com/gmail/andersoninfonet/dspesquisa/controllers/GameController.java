package com.gmail.andersoninfonet.dspesquisa.controllers;

import java.util.List;

import com.gmail.andersoninfonet.dspesquisa.dto.GameDTO;
import com.gmail.andersoninfonet.dspesquisa.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        io.opentracing.contrib.jdbc.TracingDriver.setInterceptorMode(true);
        return ResponseEntity.ok().body(gameService.findALL());
    }
}