package com.book.service;

import com.book.dto.UserDto;

public interface UserService {

    UserDto getUserDto(Long id);

    UserDto addUser(UserDto userDto);

    UserDto removeUser(Long id);

    UserDto updateUser(UserDto userDto);

}
