package com.example.narshaback.base.projection.like;

import com.example.narshaback.entity.UserEntity;

public interface GetLikeList {

    Integer getLikeId();
    UserEntity getUserId();

    interface UserEntity{
        String getUserId();

        String getUserName();

        String getProfileImage();

    }
}
