package com.example.demo;


import com.example.demo.entities.User;
import com.example.demo.repositories.UserDataRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmcmFuY2lzY28iLCJleHAiOjE2NTk2MDgwNzksImlhdCI6MTY1OTU5MDA3OX0.pmmmfcgJjnUe4bJkVfi4FaAKVebxQruZiU5P9UUJXkl09xKD1EibunQYBc_EDJ6ozmLfp4n-OnH7AvEYkNrzfA";

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDataRepository phoneRepository;

    
    @Test
    public void whenGetAllUser_thenOK() {
        List<User> users = new ArrayList<>();
        users.add(new User());

        given(userRepository.findAll()).willReturn(users);

        Iterable<User> expected = userService.findAll();

        assertEquals(expected, users);
        verify(userRepository).findAll();
    }

}