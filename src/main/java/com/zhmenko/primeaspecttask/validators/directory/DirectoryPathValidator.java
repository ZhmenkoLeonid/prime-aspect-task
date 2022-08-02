package com.zhmenko.primeaspecttask.validators.directory;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.file.Path;

@Slf4j
public class DirectoryPathValidator implements ConstraintValidator<DirectoryPath, String> {
    private Boolean isWindows;
    private final String unixPattern = "^/|(/[\\w-]+)+$";

    @Override
    public boolean isValid(String saveDirPath, ConstraintValidatorContext constraintValidatorContext) {
        if (isWindows == null) isWindows = System.getProperty("os.name").startsWith("Windows");
        if (isWindows) {
            try {
                Path.of(saveDirPath);
            } catch (Exception e) {
                return false;
            }
            return !saveDirPath.contains(".");
        } else return saveDirPath.matches(unixPattern);
    }
}
