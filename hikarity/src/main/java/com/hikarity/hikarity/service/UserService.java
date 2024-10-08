package com.hikarity.hikarity.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hikarity.hikarity.DTO.Pagination;
import com.hikarity.hikarity.DTO.PagingResponse;
import com.hikarity.hikarity.DTO.SearchDto;
import com.hikarity.hikarity.mapper.HikarityMapper;

@Service
public class UserService {
    @Autowired
    private HikarityMapper mapper;

    public List<Map<String, Object>> getAll() {
        
        // int count = mapper.count(params);
        // if (count < 1) {
        //     return new PagingResponse<>(Collections.emptyList(), null);
        // }
        
        // Pagination pagination = new Pagination(count, params);
        // params.setPagination(pagination);

        // List<Map<String, Object>> list = mapper.getAll(params);
        // return new PagingResponse<>(list, pagination);
        
        return mapper.getAll();
    }

    // public PagingResponse<PostResponse> findAllPost();

    public Map<String, Object> getDetailedAnimal(String Idx) {
        return mapper.getDetailedAnimal(Idx);
    }

    public Map<String, Object> test() {
        return mapper.test();
    }
    
}
