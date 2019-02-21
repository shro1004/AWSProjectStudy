package com.lgcns.kyun.AWSProjectStudy.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.kyun.AWSProjectStudy.domain.posts.PostsRepository;
import com.lgcns.kyun.AWSProjectStudy.dto.PostsSaveRequestDto;
import com.lgcns.kyun.AWSProjectStudy.service.PostsService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsService postsService;
	private Environment env;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
    
    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
