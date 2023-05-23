package com.example.narshaback.repository;

import com.example.narshaback.entity.GroupEntity;
import com.example.narshaback.entity.NoticeEntity;
import com.example.narshaback.projection.GetNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<NoticeEntity ,Integer> {
    List<GetNotice> findByGroupId(GroupEntity GroupId);
    Optional<NoticeEntity> findById(Integer NoticeId);
}