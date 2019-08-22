package com.springtest.ws.ui.controller;

import com.springtest.ws.service.UserService;
import com.springtest.ws.ui.model.request.LoginRequestModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    UserService userService;

    @ApiOperation("User Login")
    @ApiResponses(value={
        @ApiResponse(code = 200,
            message = "Response Headers",
                responseHeaders = {
                    @ResponseHeader(name = "authorization",
                        description = "Bearer <JWT Value Here>",
                        response = String.class),
                    @ResponseHeader(name = "userId",
                        description = "<Public UserId Value Here>",
                        response = String.class)
                })
    })

    @PostMapping("/users/login")
    public void theFakeLogin(@RequestBody LoginRequestModel loginRequestModel) {
        throw new IllegalStateException("This method should not be called. This method is implemented by Spring Security");

    }
}
