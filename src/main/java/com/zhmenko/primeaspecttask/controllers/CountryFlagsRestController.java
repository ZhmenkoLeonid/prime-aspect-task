package com.zhmenko.primeaspecttask.controllers;

import com.zhmenko.primeaspecttask.model.request.CountryFlagsRequest;
import com.zhmenko.primeaspecttask.services.CountryFlagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flags")
@RequiredArgsConstructor
public class CountryFlagsRestController {
    private final CountryFlagsService countryFlagsService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void downloadCountryFlags(@RequestBody @Valid CountryFlagsRequest request) {
        countryFlagsService.receiveCountries(request);
    }
}
