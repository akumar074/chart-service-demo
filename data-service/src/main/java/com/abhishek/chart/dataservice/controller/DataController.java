package com.abhishek.chart.dataservice.controller;

import com.abhishek.chart.dataservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class DataController {

    @Autowired
    DataService dataService;

    public String getData(@RequestBody String inputData) {
        return dataService.getData();
    }
}
