package org.project.jobportal.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
