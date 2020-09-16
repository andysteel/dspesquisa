package com.gmail.andersoninfonet.dspesquisa.services;

import java.time.Instant;

import com.gmail.andersoninfonet.dspesquisa.dto.RecordDTO;
import com.gmail.andersoninfonet.dspesquisa.dto.RecordInsertDTO;
import com.gmail.andersoninfonet.dspesquisa.entities.Record;
import com.gmail.andersoninfonet.dspesquisa.repositories.GameRepository;
import com.gmail.andersoninfonet.dspesquisa.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
    
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        entity.setGame(gameRepository.getOne(dto.getGameId()));

        return new RecordDTO(recordRepository.save(entity));
    }

    @Transactional(readOnly = true)
	public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return recordRepository.findByMoment(minDate, maxDate, pageRequest).map(r -> new RecordDTO(r));
	}
}