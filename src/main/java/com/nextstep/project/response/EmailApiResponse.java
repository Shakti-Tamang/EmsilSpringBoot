package com.nextstep.project.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class EmailApiResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("statusCode")
    int statusCode;


}
