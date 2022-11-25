package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    // register a user
    @Transactional  // use this when saving something to the database ensures transaction that gets opened with data source is resolved
    List<String> addUser(UserDto userDto);
    // log in a user
    List<String> userLogin(UserDto userDto);
}
