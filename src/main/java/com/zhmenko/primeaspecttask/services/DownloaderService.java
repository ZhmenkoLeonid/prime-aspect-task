package com.zhmenko.primeaspecttask.services;

import com.zhmenko.primeaspecttask.model.ImageFormat;
import com.zhmenko.primeaspecttask.model.client.RestCountriesAPIFlagsResponseItem;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.List;

public interface DownloaderService {
    @SneakyThrows
    void downloadAndSaveFile(URL fileUrl, String destinationDir, String fileName, String fileExtension);
    @SneakyThrows
    void downloadAndSaveFiles(List<RestCountriesAPIFlagsResponseItem> flagsImgInfo, String destinationDir, ImageFormat imageFormat);
}
