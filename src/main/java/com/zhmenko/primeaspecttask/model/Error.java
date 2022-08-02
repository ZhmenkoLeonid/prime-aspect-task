package com.zhmenko.primeaspecttask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
  private Integer code;
  private String message;
}

