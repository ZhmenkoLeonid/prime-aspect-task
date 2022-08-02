package com.zhmenko.primeaspecttask.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhmenko.primeaspecttask.model.ImageFormat;
import com.zhmenko.primeaspecttask.validators.directory.DirectoryPath;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CountryFlagsRequest {
    @NotEmpty
    private List<String> countriesCodesList;
    @DirectoryPath
    @JsonProperty("saveDirectoryPath")
    private String saveDirPath;
    @NotNull
    private ImageFormat imageFormat;
}
