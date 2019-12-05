package com.mts.cdc.authenticationservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    public String Message;
    public AuthenticationPayloadV1 Contents;
}
