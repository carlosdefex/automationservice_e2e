package com.co.testrappi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "password"
})
@Setter
@Getter
public class Loguin {

    public Loguin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password;

}