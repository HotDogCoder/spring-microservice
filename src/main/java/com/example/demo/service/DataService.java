package com.example.demo.service;

import com.example.demo.model.DataEntity;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public DataEntity saveData(String data) {
        DataEntity entity = new DataEntity();
        entity.setData(data);
        return dataRepository.save(entity);
    }
}