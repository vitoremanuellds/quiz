package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.User;
import com.demo.quiz.dto.UserDTO;

public class UserMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);

        return userDTO;
    }


    public User convertFromUserDTO(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);

        return user;
    }

}
