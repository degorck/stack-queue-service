package com.globant.stackqueueservice.service;

import com.globant.stackqueueservice.dto.UserDto;

import java.util.LinkedList;
import java.util.Stack;

public interface UserStackService {

    /**
     * This method request for a user and adds it to a Stack. Returns the request user
     * to process as confirmation.
     * @param user Is the user you want to add to the Stack.
     * @return Returns the user on the request as confirmation.
     */
    UserDto addUserToStack(UserDto user);

    /**
     * This method will return a Stack of users.
     * @return Returns the users Queue added on "addUserToQueue" method.
     */
    LinkedList<UserDto> getUserStack();
}
