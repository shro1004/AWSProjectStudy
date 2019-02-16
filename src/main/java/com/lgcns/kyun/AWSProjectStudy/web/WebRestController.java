package com.lgcns.kyun.AWSProjectStudy.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.kyun.AWSProjectStudy.domain.posts.PostsRepository;
import com.lgcns.kyun.AWSProjectStudy.dto.PostsSaveRequestDto;
import com.lgcns.kyun.AWSProjectStudy.service.PostsService;


@RestController
public class WebRestController {
	
	private PostsService postsService;


    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
