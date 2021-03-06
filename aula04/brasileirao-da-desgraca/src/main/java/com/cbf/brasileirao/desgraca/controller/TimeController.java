package com.cbf.brasileirao.desgraca.controller;

import com.cbf.brasileirao.desgraca.request.CriarTimeRequest;
import com.cbf.brasileirao.desgraca.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService service;

    @PostMapping
    public Integer criarTime(@RequestBody CriarTimeRequest request) {
        return service.criarTime(request);
    }



}
