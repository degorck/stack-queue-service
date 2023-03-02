package com.globant.stackqueueservice.service.impl;

import com.globant.stackqueueservice.dto.UserDto;
import com.globant.stackqueueservice.service.UserStackService;
import com.globant.stackqueueservice.utils.MyStack;
import com.globant.stackqueueservice.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Slf4j
@Service
public class UserStackServiceImpl implements UserStackService {

    @Autowired
    ServiceUtils serviceUtils;

    private MyStack<UserDto> stack = new MyStack<UserDto>(3);

    @Override
    public UserDto addUserToStack(UserDto user) {
        log.info("addUserToStack");
        stack.push(user);
        serviceUtils.saveOperation(user);
        return user;
    }

    @Override
    public LinkedList<UserDto> getUserStack() {
        serviceUtils.saveOperation("User stack requested");
        LinkedList<UserDto> list = new LinkedList<UserDto>();
        list.clear();
        log.info("Peek: [Name: {}, Pet:{}]", stack.peek().getName(), stack.peek().getPet());
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        log.info("getUserQueue");
        return list;
    }
}
