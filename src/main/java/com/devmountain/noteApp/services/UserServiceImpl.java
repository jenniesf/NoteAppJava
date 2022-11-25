package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service Layer is where the business logic resides.
    // This is the brains of the operation lives here. This is the
    // layer where you are receiving information from the Repository Layer,
    // performing any necessary transformations and then passing them
    // on to the Controller to handle the request.

// First we need to resolve our Dependencies that we need for this class to work.
    // Service Layer interacts with the Repository Layer.
    // Spring handles the Dependency Injection for us, thanks to the @Repository
    // annotation we added to our Repositories. Because of this, Spring is able to
    // find the corresponding dependency and inject it where it is needed throughout
    // the application by using the @Autowired annotation.

// Things to do: add a new User, verify credentials during log in

@Service
public class UserServiceImpl implements UserService {
    @Autowired  // Spring is able to find the corresponding dependency and inject it
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // register a user
    @Override
    @Transactional  // use this when saving something to the database ensures transaction that gets opened with data source is resolved
    public List<String> addUser(UserDto userDto){

        List<String> response = new ArrayList<>();

        User user = new User(userDto); // create new user

        userRepository.saveAndFlush(user);  // to persist a user

//        response.add("User Added Successfully");
        response.add("http://localhost:8080/login.html");

        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto) {

        List<String> response = new ArrayList<>();

        // Optionals are there as a way to avoid “NullPointerExceptions”
            // which will break your code and crash your application, you can think
            // of it as a box and that box can either be empty or have something in it.
            // The compiler does care whether it’s empty or full, it just needs to know it’s a box.
        Optional<User> userOptional = userRepository.findByUsername( userDto.getUsername() );

        // check first to see if “userOptional” (data from DB) is present, using the “isPresent” method
            // available on Optionals. After we know it’s present then we can check to see if
            // the password from user matches the hash pw from the DB.
        if( userOptional.isPresent() ) {
            if( passwordEncoder.matches( userDto.getPassword() , userOptional.get().getPassword() ) ) {
                // response.add("User Login Successful");
                response.add("http://localhost:8080/home.html");
                response.add(String.valueOf( userOptional.get().getId() ));  //add user id to response list so front end can use the id if they need to
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }


}
