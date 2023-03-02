package com.globant.stackqueueservice.service;

import com.globant.stackqueueservice.dto.UserDto;
import com.globant.stackqueueservice.service.impl.UserQueueServiceImpl;
import com.globant.stackqueueservice.utils.ServiceUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserQueueServiceImplTest {

    @Mock
    private ServiceUtils serviceUtils;

    @InjectMocks
    private UserQueueServiceImpl userQueueService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUserToQueue() {
        UserDto user = new UserDto();
        user.setName("John");
        user.setPet("Cat");
        UserDto result = userQueueService.addUserToQueue(user);
        verify(serviceUtils, times(1)).saveOperation(user);
        assertEquals(user, result);
    }

    @Test
    public void testGetUserQueue() {
        UserDto user1 = new UserDto();
        user1.setName("John");
        user1.setPet("Cat");
        UserDto user2 = new UserDto();
        user2.setName("Jane");
        user2.setPet("Dog");
        UserDto user3 = new UserDto();
        user3.setName("Jim");
        user3.setPet("Fish");
        userQueueService.addUserToQueue(user1);
        userQueueService.addUserToQueue(user2);
        userQueueService.addUserToQueue(user3);
        LinkedList<UserDto> result = userQueueService.getUserQueue();
        verify(serviceUtils, times(1)).saveOperation("User queue requested");
        assertEquals(3, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
        assertEquals(user3, result.get(2));
    }

}