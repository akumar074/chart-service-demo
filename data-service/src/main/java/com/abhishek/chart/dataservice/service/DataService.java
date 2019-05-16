package com.abhishek.chart.dataservice.service;

import com.abhishek.chart.dataservice.Model.DataTO;

public interface DataService {

    public DataTO[] getData(String startDate, String endDate);
}
