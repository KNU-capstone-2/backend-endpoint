package com.knu.cloudapi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class InstanceControlResponse {
    private boolean isSuccess;

    private String message;
}
