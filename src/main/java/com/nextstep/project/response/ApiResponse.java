package com.nextstep.project.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiResponse<T> {
@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Message")
    String message;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("statusCode")
    int statusCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("List")
    List<T>list;
}
