package com.hikarity.hikarity.controller;

import java.util.HashMap; // 추가된 import 문
import java.util.List;
import java.util.Map;
import java.util.Collections;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.hikarity.hikarity.DTO.SearchDto;
import com.hikarity.hikarity.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@Controller
public class ThymeleafController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        return "main"; // main.html 뷰를 반환
    }

    @GetMapping("/api/animals")
@ResponseBody
public Map<String, Object> getAnimals(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String search) { // 검색어 추가
        
                Map<String, Object> response = new HashMap<>();
            try {
                List<Map<String, Object>> allAnimals = userService.getAll();
                System.out.println("==============================");
                System.out.println("카테고리 : " + category);
                System.out.println("==============================");
                // 카테고리 필터링
                if (category != null && !category.isEmpty()) {

                    if (category != null && !category.isEmpty()) {
                        allAnimals = allAnimals.stream()
                            .filter(animal -> animal.get("category").equals(category))
                            .collect(Collectors.toList());
                    }


                        
                    // } else {
                    //     allAnimals = allAnimals.stream()
                    //         // .filter(animal -> animal.get("category").equals(category))
                    //         .filter(animal -> animal.get("SPECIES_NM").toString().contains(category))
                    //         .collect(Collectors.toList());
                    // }
                }

        // 검색어 필터링
        if (search != null && !search.isEmpty()) {
            allAnimals = allAnimals.stream()
                .filter(animal -> animal.get("SPECIES_NM").toString().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        }

        int totalItems = allAnimals.size();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        int start = page * size;
        int end = Math.min(start + size, totalItems);
        
        List<Map<String, Object>> paginatedAnimals = allAnimals.subList(start, end);

        response.put("animals", paginatedAnimals);
        response.put("totalPages", totalPages);
        response.put("currentPage", page);
        } catch (Exception e) {
            log.error("Error fetching animals: ", e);
            response.put("error", "동물 정보를 가져오는 데 문제가 발생했습니다.");
        }
    return response;
    }


    @GetMapping("/animal/{Idx}")
    public String getDetailedAnimal(@PathVariable("Idx") String Idx, Model model) {
        Map<String, Object> animal = userService.getDetailedAnimal(Idx);  // Fetch the details of the animal by ID
        
        model.addAttribute("animal", animal);
        return "detail";
    }
    
}
