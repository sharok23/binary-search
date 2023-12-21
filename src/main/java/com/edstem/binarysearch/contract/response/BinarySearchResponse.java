package com.edstem.binarysearch.contract.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BinarySearchResponse {
    private long indexValue;
    private long executionTime;
}
