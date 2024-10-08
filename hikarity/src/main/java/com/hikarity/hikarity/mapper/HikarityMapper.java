package com.hikarity.hikarity.mapper;

import java.util.List;
import java.util.Map;

import com.hikarity.hikarity.DTO.SearchDto;



public interface HikarityMapper {
        List<Map<String, Object>> getAll();
        Map<String, Object> test();
        Map<String, Object> getDetailedAnimal(String Idx);

}