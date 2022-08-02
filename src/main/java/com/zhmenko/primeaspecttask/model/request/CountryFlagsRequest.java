package com.zhmenko.primeaspecttask.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhmenko.primeaspecttask.model.ImageFormat;
import com.zhmenko.primeaspecttask.validators.directory.DirectoryPath;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CountryFlagsRequest {
    @NotEmpty
    @ApiModelProperty(example = "[\"ru\",\"us\",\"col\",\"pe\"]", value = "Список кодов стран.")
    private List<String> countriesCodesList;
    @DirectoryPath
    @JsonProperty("saveDirectoryPath")
    @ApiModelProperty(example = "C:\\tmp\\countries\\flags", value = "Путь к папке, где будут сохраняться картинки флагов")
    private String saveDirPath;
    @NotNull
    @ApiModelProperty(example = "png", value = "Формат изображения. Доступны: png, svg")
    private ImageFormat imageFormat;
}