package com.zhmenko.primeaspecttask.services;

import com.zhmenko.primeaspecttask.model.request.CountryFlagsRequest;

public interface CountryFlagsService {
    void receiveCountries(CountryFlagsRequest countryFlagsRequest);
}
