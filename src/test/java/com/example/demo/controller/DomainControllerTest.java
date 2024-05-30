package com.example.demo.controller;

import com.example.demo.model.DataEntity;
import com.example.demo.service.DataService;
import com.example.demo.dto.RequestDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DomainControllerTest {

    @InjectMocks
    private DomainController domainController;

    @Mock
    private DataService dataService;

    public DomainControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveData_Success() {
        RequestDto requestDto = new RequestDto();
        requestDto.setData("Test data");

        DataEntity dataEntity = new DataEntity();
        dataEntity.setData("Test data");

        when(dataService.saveData(requestDto.getData())).thenReturn(dataEntity);

        ResponseEntity<DataEntity> response = domainController.saveData(requestDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dataEntity, response.getBody());
        verify(dataService, times(1)).saveData(requestDto.getData());
    }

    @Test
    public void testSaveData_InternalServerError() {
        RequestDto requestDto = new RequestDto();
        requestDto.setData("Test data");

        when(dataService.saveData(requestDto.getData())).thenThrow(new RuntimeException("Test Exception"));

        ResponseEntity<DataEntity> response = domainController.saveData(requestDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(dataService, times(1)).saveData(requestDto.getData());
    }
}
