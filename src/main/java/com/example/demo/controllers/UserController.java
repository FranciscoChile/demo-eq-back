package com.example.demo.controllers;

import com.example.demo.responses.APIResponse;
import com.example.demo.services.UserService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<APIResponse> findAll() {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResultados(userService.findAll());
        apiResponse.setResponseCode(HttpStatus.OK);
        apiResponse.setMessage("Successfully executed");

        return new ResponseEntity<>(apiResponse, apiResponse.getResponseCode());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<APIResponse> save(@RequestParam("file") MultipartFile file) throws IOException {

        userService.save(file.getInputStream());

        APIResponse apiResponse = new APIResponse();
        apiResponse.setResultados("");
        apiResponse.setResponseCode(HttpStatus.OK);
        apiResponse.setMessage("Successfully executed");

        return new ResponseEntity<>(apiResponse, apiResponse.getResponseCode());
    }

}
