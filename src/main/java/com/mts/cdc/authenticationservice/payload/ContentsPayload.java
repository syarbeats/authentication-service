package com.mts.cdc.authenticationservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentsPayload {

    private int id;
    private String username;
    private String password;
    private String role;
    private String email;
    private boolean enabled;
}
