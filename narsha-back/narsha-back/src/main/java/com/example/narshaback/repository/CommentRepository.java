package com.example.narshaback.repository;

import com.example.narshaback.entity.CommentEntity;
import com.example.narshaback.entity.PostEntity;
import com.example.narshaback.projection.comment.GetComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<GetComment> findByPost(PostEntity postId);
}