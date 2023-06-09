package com.example.narshaback.base.dto.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @NotNull
    public String userId;
    @NotNull
    public String password;
}
