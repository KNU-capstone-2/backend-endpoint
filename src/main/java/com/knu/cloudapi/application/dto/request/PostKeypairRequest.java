package com.knu.cloudapi.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostKeypairRequest {
    private String keypairName;

    private String keypairType;
}
