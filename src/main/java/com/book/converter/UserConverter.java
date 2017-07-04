package com.book.converter;

import com.book.dto.UserDto;
import com.book.model.User;
import com.google.common.base.Converter;

import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, UserDto> {

    @Override
    public UserDto doForward(User source) {
        UserDto dto = new UserDto();
        dto.setId(source.getId());
        dto.setLogin(source.getLogin());
        return dto;
    }

    @Override
    public User doBackward(UserDto source) {
        User user = new User();
        user.setLogin(source.getLogin());
        user.setId(source.getId());
        user.setPassword(source.getPassword());
        return user;
    }
}
