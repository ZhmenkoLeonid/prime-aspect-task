package com.zhmenko.primeaspecttask.client;

import com.zhmenko.primeaspecttask.model.client.RestCountriesAPIFlagsResponseItem;
import com.zhmenko.primeaspecttask.model.exceptions.BadRequestException;
import com.zhmenko.primeaspecttask.model.exceptions.CountriesNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestCountriesClient {
    private final RestTemplate restTemplate;

    @Value("${flags.api.url}")
    private String apiUrl;

    public List<RestCountriesAPIFlagsResponseItem> receiveFlagsImgLinksByCountryCodes(List<String> countriesCodesList) {
        String request = apiUrl + "?codes=" + String.join(",", countriesCodesList) + "&fields=flags,name";
        ResponseEntity<RestCountriesAPIFlagsResponseItem[]> responseEntity = restTemplate.getForEntity(request, RestCountriesAPIFlagsResponseItem[].class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) throw new BadRequestException();
        RestCountriesAPIFlagsResponseItem[] response = responseEntity.getBody();
        if (response.length == 0) throw new CountriesNotFoundException();
        return Arrays.asList(response);
    }
}