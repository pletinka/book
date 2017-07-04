package com.book.service.impl;

import com.book.converter.UserConverter;
import com.book.dto.UserDto;
import com.book.model.User;
import com.book.repository.CommonDao;
import com.book.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private UserConverter userConverter;

    @Transactional
    @Override
    public UserDto getUserDto(Long id) {
        User user = commonDao.read(User.class, id);
        return userConverter.doForward(user);
    }

    @Transactional
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userConverter.doBackward(userDto);
        commonDao.create(user);
        return getUserDto(user.getId());
    }
}

