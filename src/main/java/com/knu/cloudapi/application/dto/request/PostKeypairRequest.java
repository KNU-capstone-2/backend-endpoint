package com.knu.cloudapi.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostKeypairRequest {
    private String keypairName;

    private String keypairType;
}
