package com.example.narshaback.base.dto.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeDTO {

    private String userId; // user id

    private String groupCode; // group code

    private Integer postId; // 포스트 id
}
