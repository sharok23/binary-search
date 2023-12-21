package com.edstem.binarysearch.service;

import com.edstem.binarysearch.contract.request.BinarySearchRequest;
import com.edstem.binarysearch.contract.response.BinarySearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BinarySearchService {

    public BinarySearchResponse binarySearch(BinarySearchRequest request, long value) {
        List<Integer> array = request.getNumbers();
        int left = 0;
        int right = array.size() - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (value == array.get(mid)) {
                return new BinarySearchResponse(mid);
            } else if (array.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        throw new NoSuchElementException("Value not found in array");
    }
}