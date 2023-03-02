package com.globant.stackqueueservice.service;

import com.globant.stackqueueservice.dto.UserDto;

import java.util.LinkedList;

public interface UserQueueService {
    /**
     * This method request for a user and adds it to a Queue. Returns the request user
     * to process as confirmation.
     * @param user Is the user you want to add to the Queue.
     * @return Returns the user on the request as confirmation.
     */
    UserDto addUserToQueue(UserDto user);

    /**
     * This method will return a Queue of users.
     * @return Returns the users Queue added on "addUserToQueue" method.
     */
    LinkedList<UserDto> getUserQueue();
}
