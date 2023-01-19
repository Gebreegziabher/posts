package edu.miu.waarestful.controller;

import edu.miu.waarestful.entity.Post;
import edu.miu.waarestful.entity.dto.PostDto;
import edu.miu.waarestful.entity.dto.PostV2Dto;
import edu.miu.waarestful.service.PostService;
import edu.miu.waarestful.service.PostV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api")
@RestController
public class PostController {
    private final PostService service;
    private final PostV2Service v2Service;

    @Autowired
    public PostController(PostService service, PostV2Service v2Service) {
        this.service = service;
        this.v2Service = v2Service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/posts")
    //@GetMapping(value = "/posts/header", headers = "X-API-VERSION=1")
    public List<PostDto> getAllV1(){
        return service.findAll();
    }

    //@GetMapping("/v2/posts")
    @GetMapping(value = "/posts/header", headers = "X-API-VERSION=2")
    public List<PostV2Dto> getAllV2(){
        return v2Service.findAll();
    }

    @GetMapping("/v1/posts/{id}")
    public PostDto getPostV1(@PathVariable("id") UUID id){
        return service.findById(id);
    }

    @GetMapping("/v2/posts/{id}")
    public PostV2Dto getPostV2(@PathVariable("id") UUID id){
        return v2Service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/posts")
    public void save( @RequestBody PostDto postDto){
        service.save(postDto);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v2/posts")
    public void save( @RequestBody PostV2Dto postDto){
        v2Service.save(postDto);
    }

    @PutMapping("/v1/posts/{id}")
    public void update(@PathVariable("id") UUID id, @RequestBody PostDto p) {
        service.update(id,p);
    }

    @PutMapping("/v2/posts/{id}")
    public void update(@PathVariable("id") UUID id, @RequestBody PostV2Dto p) {
        v2Service.update(id,p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1/posts/{id}")
    public void deleteV1(@PathVariable UUID id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/v2/posts/{id}")
    public void deleteV2(@PathVariable UUID id) {
        v2Service.delete(id);
    }

    @GetMapping("/v1/posts/filter")
    @ResponseBody
    public PostDto getAll(@RequestParam(required = false) String author){
        return service.findAll().stream().filter(f -> f.getAuthor().equals(author)).findFirst().orElse(new PostDto());
    }
}
