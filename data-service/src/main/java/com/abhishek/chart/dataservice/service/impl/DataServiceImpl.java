package com.abhishek.chart.dataservice.service.impl;

import com.abhishek.chart.dataservice.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;

@Service
public class DataServiceImpl implements DataService {

    private static final String FILE_PATH = "src\\main\\java\\com\\abhishek\\chart\\dataservice\\service\\impl\\output.json";

    @Override
    public String getData(String startDate, String endDate) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            result = jsonArray.toJSONString();
//            result = mapper.writeValueAsString(jsonArray);
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

}
