package com.globallogic.library.controllers;

import com.globallogic.library.entities.User;
import com.globallogic.library.model.Gender;
import com.globallogic.library.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {


    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @Test
    public void testCreate() {

        User user = User.builder()
                .firstName("Deepthy")
                .lastName("george")
                .contact("999999999")
                .gender(Gender.F)
                .emailId("deepthy@gmail.com")
                .password("password")
                .id(1)
                .build();
        Mockito.when(userService.create(Mockito.any()))
                .thenReturn(user);
        Assert.assertEquals(1, userController.createUser(user).getId());

    }

    @Test
    public void testLogin() {
        User user = User.builder()
                .firstName("Deepthy")
                .lastName("george")
                .contact("999999999")
                .gender(Gender.F)
                .emailId("deepthy@gmail.com")
                .password("password")
                .build();
        ResponseEntity sucessResponseEntity = ResponseEntity.status(200)
                .body("USER LOGIN SUCCESS");
        ResponseEntity failureResponseEntity = ResponseEntity.status(401)
                .body("USER LOGIN FAILED");

        Mockito.when(userService.authenticateUserCredentials("deepthy@gmail.com","password"))
                .thenReturn(true);
        Assert.assertEquals(sucessResponseEntity, userController.login("deepthy@gmail.com","password"));

        Mockito.when(userService.authenticateUserCredentials(Mockito.anyString(),Mockito.anyString()))
                .thenReturn(false);
        Assert.assertEquals(failureResponseEntity, userController.login("deepthy@gmail.com","password"));

    }


}
