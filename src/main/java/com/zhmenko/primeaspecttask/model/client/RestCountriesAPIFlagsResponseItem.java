package com.zhmenko.primeaspecttask.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.Map;

@Data
@NoArgsConstructor
public class RestCountriesAPIFlagsResponseItem {
    private boolean independent;
    @JsonProperty("name")
    private String countryName;
    @JsonProperty("flags")
    private Map<String, URL> flagsImgLinks;
}