package com.example.narshaback.service;

import com.example.narshaback.dto.group.JoinGroupDTO;
import com.example.narshaback.entity.GroupEntity;
import com.example.narshaback.entity.ProfileEntity;
import com.example.narshaback.entity.UserEntity;
import com.example.narshaback.entity.User_Group;
import com.example.narshaback.projection.user.GetUserInGroup;
import com.example.narshaback.projection.user_group.GetJoinGroupList;
import com.example.narshaback.repository.GroupRepository;
import com.example.narshaback.repository.ProfileRepository;
import com.example.narshaback.repository.UserGroupRepository;
import com.example.narshaback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl implements UserGroupService{

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ProfileRepository profileRepository;

    @Override
    public Boolean joinUser(JoinGroupDTO joinGroupDTO) {
        // 해당 그룹이 없을 때 return null
        if (groupRepository.findByGroupCode(joinGroupDTO.getGroupCode()) == null) return false;
        User_Group user_group = User_Group.builder()
                .user(userRepository.findByUserId(joinGroupDTO.getUserId())) // 유저로 넣어주기
                .group(groupRepository.findByGroupCode(joinGroupDTO.getGroupCode())) // // 그룹으로 넣어주기
                .build();
        userGroupRepository.save(user_group);

        // profile 생성
        List<Boolean> newBadgeList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            newBadgeList.add(false);
        }

        ProfileEntity profile = ProfileEntity.builder()
                .userGroup(user_group)
                .badgeList(newBadgeList.toString())
                .build();
        profileRepository.save(profile);

        return true;
    }

    @Override
    public List<GetUserInGroup> getUserListInGroup(String groupId) {
        GroupEntity group = groupRepository.findByGroupCode(groupId);
        List<GetUserInGroup> userList = userGroupRepository.findByGroup(group);

        return userList;
    }

    @Override
    public List<GetJoinGroupList> getJoinGroupList(String userId) {
        UserEntity user = userRepository.findByUserId(userId);
        List<GetJoinGroupList> groupList = userGroupRepository.findByUser(user);

        return groupList;
    }
}
