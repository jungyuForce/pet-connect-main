package com.hikarity.hikarity.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class PagingResponse<T> {

    private List<Map<String, Object>> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<Map<String, Object>> list, Pagination pagination) {
        this.list.addAll(list);
        this.pagination = pagination;
    }

}

