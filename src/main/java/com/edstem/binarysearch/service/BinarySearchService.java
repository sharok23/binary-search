package com.edstem.binarysearch.service;

import com.edstem.binarysearch.contract.request.BinarySearchRequest;
import com.edstem.binarysearch.contract.response.BinarySearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BinarySearchService {

    public BinarySearchResponse binarySearch(BinarySearchRequest request, long value) {
        long startTime = System.nanoTime();
        List<Integer> array = request.getNumbers();
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value == array.get(mid)) {
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                return new BinarySearchResponse(mid, executionTime);
            } else if (array.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        throw new NoSuchElementException("Value not found in array. Execution time: " + executionTime);
    }
}