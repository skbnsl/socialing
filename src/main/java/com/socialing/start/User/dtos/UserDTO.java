package com.socialing.start.User.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private String firstName;
    private String lastName;

    private String email;

    private String passwordHash;

}
