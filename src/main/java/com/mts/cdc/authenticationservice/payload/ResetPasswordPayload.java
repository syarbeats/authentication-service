package com.mts.cdc.authenticationservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordPayload {
    private String email;
}
