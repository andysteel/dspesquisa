package com.gmail.andersoninfonet.dspesquisa.controllers;

import com.gmail.andersoninfonet.dspesquisa.dto.RecordDTO;
import com.gmail.andersoninfonet.dspesquisa.dto.RecordInsertDTO;
import com.gmail.andersoninfonet.dspesquisa.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records")
public class RecordController {
    
    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recordService.insert(dto));
    }
}