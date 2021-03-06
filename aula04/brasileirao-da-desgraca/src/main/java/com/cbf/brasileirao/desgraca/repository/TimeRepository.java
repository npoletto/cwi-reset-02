package com.cbf.brasileirao.desgraca.repository;

import com.cbf.brasileirao.desgraca.entity.TimeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimeRepository {

    private List<TimeEntity> times = new ArrayList<>();

    public void criarTime(TimeEntity time) {
        times.add(time);
    }
}
