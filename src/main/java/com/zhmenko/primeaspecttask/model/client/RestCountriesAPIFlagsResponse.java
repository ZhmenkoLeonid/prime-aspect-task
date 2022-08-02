package com.zhmenko.primeaspecttask.model.client;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class RestCountriesAPIFlagsResponse {
    private List<RestCountriesAPIFlagsResponseItem> itemList;

    public RestCountriesAPIFlagsResponse() {
        itemList = new ArrayList<>();
    }
}
