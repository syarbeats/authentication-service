package com.mts.cdc.authenticationservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivatePayload {

    private String contents;
    private String message;
}
