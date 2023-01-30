package com.example.swtodo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDTO {
    private List<ImsiDTO> dtoList;
    private int page;
    private int priv;
    private int next;
    private int start;
    private int end;
    private List pageList;
    private int totalPage;
    private String email;
    private String token;
    
}
