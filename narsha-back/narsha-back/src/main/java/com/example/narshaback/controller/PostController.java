package com.example.narshaback.controller;

import com.example.narshaback.base.code.ResponseCode;
import com.example.narshaback.base.dto.response.ResponseDTO;
import com.example.narshaback.base.dto.s3.S3FileDTO;
import com.example.narshaback.base.dto.post.UploadPostDTO;
import com.example.narshaback.base.projection.post.GetPostDetail;
import com.example.narshaback.base.projection.post.GetUserPost;
import com.example.narshaback.service.AmazonS3Service;
import com.example.narshaback.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController // JSON 형태의 결과값 반환
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    private final AmazonS3Service amazonS3Service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO> uploadPost(@RequestParam(value="fileType") String fileType, @RequestPart("images") List<MultipartFile> multipartFiles,
                                                  @RequestParam(value="info")String uploadPostDTO) throws JsonProcessingException {

        // mapper
        ObjectMapper mapper = new ObjectMapper();
        UploadPostDTO mapperUploadPostDTO = mapper.readValue(uploadPostDTO, UploadPostDTO.class);


        // S3에 이미지 저장
        List<S3FileDTO> uploadFiles = amazonS3Service.uploadFiles(fileType, multipartFiles);

        // S3에서 받은 URL String Array
        List<String> imageUrlArray = new ArrayList<>();

        for(S3FileDTO url: uploadFiles){
            imageUrlArray.add(url.getUploadFileUrl());
        }

        mapperUploadPostDTO.setImageArray(imageUrlArray.toString());


        // 포스팅 내용 + 이미지 배열 저장
        Integer res = postService.uploadPost(mapperUploadPostDTO);
//        JsonObject obj = new JsonObject();
//
//        obj.addProperty("postId", res);
//
//        // 저장 여부 확인
//        if (res == null) {
//            obj.addProperty("success", false);
//            obj.addProperty("message", "포스트 업로드 실패");
//        } else{
//            obj.addProperty("success", true);
//            obj.addProperty("success", "포스트 업로드 완료!");
//        }
//
//        return obj.toString();

        return ResponseEntity
                .status(ResponseCode.SUCCESS_UPLOAD_POST.getStatus().value())
                .body(new ResponseDTO(ResponseCode.SUCCESS_UPLOAD_POST, res));
    }

    @GetMapping("/user-list")
    public ResponseEntity<ResponseDTO> getUserPostList(@RequestParam(value = "groupCode") String groupCode) {

        List<GetUserPost> res = postService.getUserPost(groupCode);

        return ResponseEntity
                .status(ResponseCode.SUCCESS_GET_POST_LIST.getStatus().value())
                .body(new ResponseDTO(ResponseCode.SUCCESS_GET_POST_LIST, res));
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseDTO> getPost(@RequestParam(value = "postId")Integer postId,
                                                 @RequestParam(value = "groupCode")String groupCode,
                                                 @RequestParam(value = "userId")String userId) {
        GetPostDetail res =  postService.getPostDetail(postId, groupCode, userId);

//        return new ResponseEntity<>(res, HttpStatus.OK);

        return ResponseEntity
                .status(ResponseCode.SUCCESS_DETAIL_POST.getStatus().value())
                .body(new ResponseDTO(ResponseCode.SUCCESS_DETAIL_POST, res));
    }
}
