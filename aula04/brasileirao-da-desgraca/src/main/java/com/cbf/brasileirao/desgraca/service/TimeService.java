package com.cbf.brasileirao.desgraca.service;

import com.cbf.brasileirao.desgraca.entity.TimeEntity;
import com.cbf.brasileirao.desgraca.mapper.CriarTimeMapper;
import com.cbf.brasileirao.desgraca.repository.TimeRepository;
import com.cbf.brasileirao.desgraca.request.CriarTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private CriarTimeMapper mapper;

    @Autowired
    private TimeRepository repository;

    private static Integer id = 0;

    public Integer criarTime(CriarTimeRequest request) {
        TimeEntity time = mapper.map(request);
        time.setId(id++);
        repository.criarTime(time);
        return id;
    }
}
