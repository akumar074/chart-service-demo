package com.abhishek.chart.dataservice.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputDataTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("dateRange")
    private DateRangeTO dateRangeTO;

    public InputDataTO() {
    }

    public InputDataTO(String id, DateRangeTO dateRangeTO) {
        this.id = id;
        this.dateRangeTO = dateRangeTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateRangeTO getDateRangeTO() {
        return dateRangeTO;
    }

    public void setDateRangeTO(DateRangeTO dateRangeTO) {
        this.dateRangeTO = dateRangeTO;
    }
}
