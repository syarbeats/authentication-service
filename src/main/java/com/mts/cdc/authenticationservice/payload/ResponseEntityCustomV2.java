package com.mts.cdc.authenticationservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntityCustomV2 {
    private Contents contents;
    private String message;
}
