package com.book.exception;public class UserNotFoundException extends RuntimeException {    public UserNotFoundException(String userName) {        super(String.format("User with name %s can not be founded", userName));    }    public UserNotFoundException(Long id) {        super(String.format("User with id %s can not be founded", id));    }}