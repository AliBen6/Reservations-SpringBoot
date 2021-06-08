package be.iccbxl.pid.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserLoginUniqueConstraintViolation extends RuntimeException {

    public UserLoginUniqueConstraintViolation(String message) {
        super(message);
    }
}
