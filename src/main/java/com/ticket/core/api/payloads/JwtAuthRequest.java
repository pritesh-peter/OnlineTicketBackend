package com.ticket.core.api.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String username;

    private String password;
}
