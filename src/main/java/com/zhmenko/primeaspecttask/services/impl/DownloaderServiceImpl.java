package com.zhmenko.primeaspecttask.services.impl;

import com.zhmenko.primeaspecttask.model.ImageFormat;
import com.zhmenko.primeaspecttask.model.client.RestCountriesAPIFlagsResponseItem;
import com.zhmenko.primeaspecttask.services.DownloaderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

@Service
@RequiredArgsConstructor
@Slf4j
public class DownloaderServiceImpl implements DownloaderService {
    @Override
    @SneakyThrows
    public void downloadAndSaveFile(URL fileUrl, String destinationDir, String fileName, String fileExtension) {
        File savePath = new File(destinationDir + "\\" + fileName + "." + fileExtension);
        FileUtils.copyURLToFile(fileUrl, savePath);
    }

    @Override
    @SneakyThrows
    public void downloadAndSaveFiles(List<RestCountriesAPIFlagsResponseItem> flagsImgInfo, String destinationDir, ImageFormat imageFormat) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(flagsImgInfo.size());
        forkJoinPool.submit(() -> processUrls(flagsImgInfo, destinationDir, imageFormat)).get();
    }

    private void processUrls(List<RestCountriesAPIFlagsResponseItem> flagImgInfoList, String saveDirPath, ImageFormat imageFormat) {
        flagImgInfoList.stream()
                .parallel()
                .forEach(flagImgInfo -> downloadAndSaveFile(
                        flagImgInfo.getFlagsImgLinks().get(imageFormat.toString()),
                        saveDirPath,
                        flagImgInfo.getCountryName(),
                        imageFormat.toString())
                );
    }
}
