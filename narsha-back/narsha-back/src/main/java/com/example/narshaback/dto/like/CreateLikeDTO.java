package com.example.narshaback.dto.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeDTO {
    private String userId; // 유저 id

    private Integer postId; // 포스트 id
}