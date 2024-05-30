package com.example.demo.controller;

import com.example.demo.model.DataEntity;
import com.example.demo.service.DataService;
import com.example.demo.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DataService dataService;

    @PostMapping("/save")
    public ResponseEntity<DataEntity> saveData(@RequestBody RequestDto requestDto) {
        try {
            DataEntity savedEntity = dataService.saveData(requestDto.getData());
            return new ResponseEntity<>(savedEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}