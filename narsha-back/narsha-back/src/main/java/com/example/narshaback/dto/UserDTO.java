package com.example.narshaback.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만듦
public class UserDTO {
    @NotNull
    private String userId;
    @NotNull
    private String password;
    @NotNull
    private String userType;
    @NotNull
    private String nikname;
    @NotNull
    private String name;

}
