package com.zhmenko.primeaspecttask.services.impl;

import com.zhmenko.primeaspecttask.client.RestCountriesClient;
import com.zhmenko.primeaspecttask.model.client.RestCountriesAPIFlagsResponseItem;
import com.zhmenko.primeaspecttask.model.request.CountryFlagsRequest;
import com.zhmenko.primeaspecttask.services.CountryFlagsService;
import com.zhmenko.primeaspecttask.services.DownloaderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesFlagsServiceImpl implements CountryFlagsService {
    private final RestCountriesClient restCountriesClient;
    private final DownloaderService downloaderService;

    @Override
    @SneakyThrows
    public void receiveCountries(CountryFlagsRequest countryFlagsRequest) {
        // Получаем ссылки на картинки флагов
        List<RestCountriesAPIFlagsResponseItem> flagsImgInfo = restCountriesClient
                .receiveFlagsImgLinksByCountryCodes(countryFlagsRequest.getCountriesCodesList());
        // Скачиваем и сохраняем флаги
        downloaderService.downloadAndSaveFiles(
                flagsImgInfo,
                countryFlagsRequest.getSaveDirPath(),
                countryFlagsRequest.getImageFormat());
    }


}
