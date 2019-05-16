package com.abhishek.chart.dataservice.service.impl;

import com.abhishek.chart.dataservice.Model.DataTO;
import com.abhishek.chart.dataservice.service.DataService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public DataTO[] getData(String startDate, String endDate) {
        return new DataTO[0];
    }


}
