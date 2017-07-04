package com.book.service;

import com.book.dto.UserDto;

public interface UserService {

    UserDto getUserDto(Long id);

    UserDto addUser(UserDto userDto);

}
