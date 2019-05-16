package com.abhishek.chart.dataservice.controller;

import com.abhishek.chart.dataservice.Model.InputDataTO;
import com.abhishek.chart.dataservice.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "data")
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity getData(@RequestBody String inputData) {
        ObjectMapper mapper = new ObjectMapper();
        String response = "";
        try {
            InputDataTO inputDataTO = mapper.readValue(inputData, InputDataTO.class);
            response = dataService.getData(inputDataTO.getDateRangeTO().getStartDate(), inputDataTO.getDateRangeTO().getEndDate());
        } catch (IOException e) {
            return new ResponseEntity("Requested data not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
