package com.globallogic.library.exceptions.errorresponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
