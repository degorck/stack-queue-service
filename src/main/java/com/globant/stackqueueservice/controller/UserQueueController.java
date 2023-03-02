package com.globant.stackqueueservice.controller;

import com.globant.stackqueueservice.dto.ResponseDto;
import com.globant.stackqueueservice.dto.UserDto;
import com.globant.stackqueueservice.service.UserQueueService;
import com.globant.stackqueueservice.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/queue/")
public class UserQueueController {

    @Autowired
    UserQueueService userQueueService;

    @Operation(summary = "Post an user and add it to a Queue")
    @PostMapping(value = "/user/")
    public ResponseEntity<ResponseDto<UserDto>> postUserQueue(@RequestBody UserDto user) {
        log.info("Receiving request with following user:[ Name: {}, Pet: {} ]", user.getName(), user.getPet());
        ResponseDto responseDto = new ResponseDto(Constants.ResponseConstant.SUCCESS.getDescription(), userQueueService.addUserToQueue(user));
        return new ResponseEntity<ResponseDto<UserDto>>(responseDto, HttpStatus.OK);
    }

    @Operation(summary = "Get an user Queue")
    @GetMapping(value = "/user/")
    public ResponseEntity<ResponseDto<UserDto>> getUserQueue() {
        log.info("Getting all the user queue");
        ResponseDto responseDto = new ResponseDto(Constants.ResponseConstant.SUCCESS.getDescription(), userQueueService.getUserQueue());
        return new ResponseEntity<ResponseDto<UserDto>>(responseDto, HttpStatus.OK);
    }
}
