package com.abhishek.chart.authservice.controller;

import com.abhishek.chart.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "getData")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity getChartData(@RequestBody String inputData,@RequestHeader(value="authToken") String authToken ) {
        if (authService.authenticate(authToken)) {
            RestTemplate restTemplate = new RestTemplate();

        } else {
            return new ResponseEntity("User Unauthorized", HttpStatus.BAD_REQUEST);
        }
    }
}
