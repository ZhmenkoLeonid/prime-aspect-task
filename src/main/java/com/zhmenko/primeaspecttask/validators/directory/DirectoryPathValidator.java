package com.zhmenko.primeaspecttask.validators.directory;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.file.Path;

@Slf4j
public class DirectoryPathValidator implements ConstraintValidator<DirectoryPath, String> {

    @Override
    public boolean isValid(String saveDirPath, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Path.of(saveDirPath);
        } catch (Exception e) {
            log.error(saveDirPath + " is not directory path");
            return false;
        }
        return !saveDirPath.contains(".");
    }
}
