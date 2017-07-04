package com.book.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserDto {
    private Long id;
    private String login;
    private String password;
}
