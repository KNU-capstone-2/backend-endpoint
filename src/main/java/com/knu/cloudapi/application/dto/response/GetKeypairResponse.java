package com.knu.cloudapi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetKeypairResponse {

    private String name;

    private String type;

    private String fingerprint;
}
