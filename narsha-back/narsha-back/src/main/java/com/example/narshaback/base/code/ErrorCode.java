package com.example.narshaback.base.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /*
     * 400 BAD_REQUEST: 잘못된 요청
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    DUPLICATE_ID_REQUEST(HttpStatus.BAD_REQUEST, "중복된 아이디가 있습니다."),
    EMPTY_COMMENT_CONTENT(HttpStatus.BAD_REQUEST, "댓글 내용이 비어있습니다."),

    DELETE_FAILED_ENTITY_RELATED_GROUPCODE(HttpStatus.BAD_REQUEST, "해당 그룹코드로 모든 엔티티 삭제를 실패했습니다."),

    /*
     * 404 NOT_FOUND: 리소스를 찾을 수 없음
     */
    USERID_NOT_FOUND(HttpStatus.NOT_FOUND, "아이디가 존재하지 않습니다."),
    PASSWORD_NOT_MATCH(HttpStatus.NOT_FOUND, "비밀번호가 올바르지 않습니다."),
    GROUPCODE_NOT_FOUND(HttpStatus.NOT_FOUND, "그룹 코드에 해당하는 그룹을 찾을 수 없습니다."),
    GROUP_NOT_FOUND(HttpStatus.NOT_FOUND, "그룹이 생성되지 않았습니다."),
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),
    COMMENTS_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글 정보를 찾을 수 없습니다."),
    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "좋아요를 찾을 수 없습니다."),

    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, "프로필 정보를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "아이디에 해당하는 유저를 찾을 수 없습니다."),
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "공지사항을 찾을 수 없습니다."),

    ALARM_NOT_FOUND(HttpStatus.NOT_FOUND, "알람에 대한 정보를 찾을 수 없습니다."),
    /*
     * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),

    /*
     * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),

    ;

    private final HttpStatus status;
    private final String message;
}
