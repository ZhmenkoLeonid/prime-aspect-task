package com.zhmenko.primeaspecttask.controllers;

import com.zhmenko.primeaspecttask.model.request.CountryFlagsRequest;
import com.zhmenko.primeaspecttask.services.CountryFlagsService;
import com.zhmenko.primeaspecttask.model.Error;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flags")
@RequiredArgsConstructor
public class CountryFlagsRestController {
    private final CountryFlagsService countryFlagsService;

    @ApiOperation(value = "", nickname = "importsPost", notes = "Скачивает картинки флагов в формате imageFormat, соответствующие кодам countriesCodesList стран, и сохраняет их по пути saveDirectoryPath.\n Имя файла формируется следующим образом: {полное_название_страны}.{формат_файла}")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Сохранение прошло успешно"),
            @ApiResponse(code = 400, message = "Невалидная схема документа или входные данные не верны.", response = Error.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка")})
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCountriesFlags(@RequestBody @Valid CountryFlagsRequest request) {
        countryFlagsService.receiveCountries(request);
    }
}
