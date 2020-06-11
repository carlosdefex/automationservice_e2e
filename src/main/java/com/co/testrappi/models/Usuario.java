package com.co.testrappi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@Getter
@Setter
public class Usuario {

    public Usuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}