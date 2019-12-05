package com.mts.cdc.authenticationservice.controller;

import com.mts.cdc.authenticationservice.payload.AuthenticationPayload;
import com.mts.cdc.authenticationservice.payload.LoginResponse;
import com.mts.cdc.authenticationservice.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthenticationController extends CrossOriginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/authentication")
    public ResponseEntity<LoginResponse> login(@RequestBody @Nonnull AuthenticationPayload authenticationPayload){

        LoginResponse response = authenticationService.login(authenticationPayload);
        return ResponseEntity.ok(response);
    }
}
