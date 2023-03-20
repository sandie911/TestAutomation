package com.hillel.api;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPojo {
    private String name;
    private String job;

    private String createdAt;
    private String email;

   private String password;
}
