package com.book.converter;

import com.book.dto.UserDto;
import com.book.model.User;
import com.google.common.base.Converter;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Component
public class UserConverter extends Converter<User, UserDto> {

    @Override
    public UserDto doForward(User source) {
        UserDto dto = new UserDto();
        dto.setId(source.getId());
        dto.setLogin(source.getLogin());
        dto.setUpdatedDate(source.getDate());
        return dto;
    }

    @Override
    public User doBackward(UserDto source) {
        User user = new User();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = dateFormat.format(date);

        user.setLogin(source.getLogin());
        user.setId(source.getId());
        user.setPassword(source.getPassword());
        user.setDate(formattedDate);
        return user;
    }
}
