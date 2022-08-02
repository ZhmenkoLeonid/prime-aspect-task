package com.zhmenko.primeaspecttask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ImageFormat {
    @JsonProperty("png")
    PNG("png"),
    @JsonProperty("svg")
    SVG("svg");

    private String format;
    ImageFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return format;
    }
}
