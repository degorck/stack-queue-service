package com.globant.stackqueueservice.service.impl;

import com.globant.stackqueueservice.dto.UserDto;
import com.globant.stackqueueservice.service.UserQueueService;
import com.globant.stackqueueservice.utils.MyQueue;
import com.globant.stackqueueservice.utils.ServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Slf4j
@Service
public class UserQueueServiceImpl implements UserQueueService {

    @Autowired
    ServiceUtils serviceUtils;

    private MyQueue<UserDto> queue = new MyQueue<UserDto>(3);

    @Override
    public UserDto addUserToQueue(UserDto user) {
        log.info("addUserToQueue");
        queue.add(user);
        serviceUtils.saveOperation(user);
        return user;
    }

    @Override
    public LinkedList<UserDto> getUserQueue() {
        serviceUtils.saveOperation("User queue requested");
        LinkedList<UserDto> list = new LinkedList<UserDto>();
        list.clear();
        log.info("Peek: [Name: {}, Pet: {}], Size: {}", queue.peek().getName(), queue.peek().getPet(), queue.size());
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        log.info("getUserQueue");
        return list;
    }
}
