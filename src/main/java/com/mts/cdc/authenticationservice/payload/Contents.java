package com.mts.cdc.authenticationservice.payload;

import com.mts.cdc.authenticationservice.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contents {

    private boolean success;
    private String message;
    private User data;
}
