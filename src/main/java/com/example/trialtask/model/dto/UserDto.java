package com.example.trialtask.model.dto;

import com.example.trialtask.model.domain.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private Set<Quote> quotes;
}
