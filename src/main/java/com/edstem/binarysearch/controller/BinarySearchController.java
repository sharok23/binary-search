package com.edstem.binarysearch.controller;

import com.edstem.binarysearch.contract.request.BinarySearchRequest;
import com.edstem.binarysearch.contract.response.BinarySearchResponse;
import com.edstem.binarysearch.service.BinarySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class BinarySearchController {
    private final BinarySearchService binarySearchService;

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    private BinarySearchResponse binarySearch(@RequestBody BinarySearchRequest request, @RequestParam long value) {
        return binarySearchService.binarySearch(request, value);
    }
}
