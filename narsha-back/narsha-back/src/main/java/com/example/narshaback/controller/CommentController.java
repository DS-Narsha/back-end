package com.example.narshaback.controller;

import com.example.narshaback.base.dto.comment.CreateCommentDTO;
import com.example.narshaback.base.projection.comment.GetComment;
import com.example.narshaback.service.CommentService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 형태의 결과값 반환
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public String createComment(@RequestBody CreateCommentDTO createCommentDTO){
        Integer commentId = commentService.createComment(createCommentDTO);
        JsonObject obj = new JsonObject();
        obj.addProperty("commentId", commentId);

        if (commentId == null) {
            obj.addProperty("message", "댓글 작성을 실패");
        } else {
            obj.addProperty("message", "댓글 작성 성공!");
        }

        return obj.toString();
    }

    @GetMapping("/list")
    public List<GetComment> getCommentList(@RequestParam(value = "postId") Integer postId, @RequestParam(value="groupCode")String groupCode){
        List<GetComment> commentList = commentService.getCommentList(postId, groupCode);

        return commentList;
    }

}
