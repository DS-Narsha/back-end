package com.example.narshaback.base.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS_REGISTER(HttpStatus.OK, "회원가입을 성공했습니다."),
    SUCCESS_LOGIN(HttpStatus.OK, "로그인을 성공했습니다."),

    SUCCESS_UNIQUE_ID(HttpStatus.OK, "중복된 아이디가 없습니다."),

    SUCCESS_JOIN_GROUP(HttpStatus.OK, "그룹에 가입되었습니다."),

    SUCCESS_CREATE_GROUP(HttpStatus.OK, "그룹 생성 성공"),

    SUCCESS_GET_GROUP_CODE(HttpStatus.OK,"그룹 코드 가져오기 성공"),

    SUCCESS_UPLOAD_POST(HttpStatus.OK, "포스트 업로드 완료!"),

    SUCCESS_GET_POST_LIST(HttpStatus.OK,"사용자 게시글 목록 불러오기 성공"),

    SUCCESS_DETAIL_POST(HttpStatus.OK, "포스트 상세 불러오기 성공"),








    ;

    private final HttpStatus status;
    private final String message;
}
