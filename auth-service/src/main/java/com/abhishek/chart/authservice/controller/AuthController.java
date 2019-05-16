package com.abhishek.chart.authservice.controller;

import com.abhishek.chart.authservice.service.AuthService;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping(value = "getData")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity getChartData(@RequestBody String inputData, @RequestHeader(value = "authToken") String authToken) {
        ResponseEntity responseEntity;
        try {
            if (authService.authenticate(authToken)) {
                RestTemplate restTemplate = new RestTemplate();
                String response = restTemplate.postForObject("http://localhost:8081/data", inputData, String.class);
                responseEntity = new ResponseEntity(response, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("User Unauthorized", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
