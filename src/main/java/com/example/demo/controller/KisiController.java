package com.example.demo.controller;

import com.example.demo.dto.KisiDto;
import com.example.demo.service.KisiService;
import java.util.List;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController //dışarı açacağımız bir api
@RequestMapping("/kisiler")
public class KisiController {

    private final KisiService kisiService;



    public KisiController(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(kisiService.save(kisiDto));

    }
    @GetMapping
    public ResponseEntity<List<KisiDto>> tumunuListele(){
        return ResponseEntity.ok(kisiService.getAll());
    }
}
