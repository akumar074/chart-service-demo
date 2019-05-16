package com.abhishek.chart.dataservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTO {

    @JsonProperty(value = "advertiserId")
    private String advertiserId;

    @JsonProperty(value = "impressions_offered")
    private int impressionsOffered;

    @JsonProperty(value = "CM001")
    private float cm001;

    public DataTO() {
    }

    public DataTO(String advertiserId, int impressionsOffered, float cm001) {
        this.advertiserId = advertiserId;
        this.impressionsOffered = impressionsOffered;
        this.cm001 = cm001;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public int getImpressionsOffered() {
        return impressionsOffered;
    }

    public void setImpressionsOffered(int impressionsOffered) {
        this.impressionsOffered = impressionsOffered;
    }

    public float getCm001() {
        return cm001;
    }

    public void setCm001(float cm001) {
        this.cm001 = cm001;
    }
}
