package com.gmail.andersoninfonet.dspesquisa.controllers;

import java.time.Instant;

import com.gmail.andersoninfonet.dspesquisa.dto.RecordDTO;
import com.gmail.andersoninfonet.dspesquisa.dto.RecordInsertDTO;
import com.gmail.andersoninfonet.dspesquisa.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
        @RequestParam(value = "min", defaultValue = "") String min,
        @RequestParam(value = "max", defaultValue = "") String max,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
        @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);
        linesPerPage = Integer.valueOf(0).equals(linesPerPage) ? Integer.MAX_VALUE : linesPerPage; 

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok().body(recordService.findByMoment(minDate, maxDate, pageRequest));
    }
}