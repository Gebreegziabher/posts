package edu.miu.waarestful.service;

import edu.miu.waarestful.entity.dto.PostV2Dto;

import java.util.List;
import java.util.UUID;

public interface PostV2Service {
    public List<PostV2Dto> findAll();

    public PostV2Dto findById(UUID id);

    public void delete(UUID id);
    public void save(PostV2Dto postDto);
    public void update(UUID id, PostV2Dto postDto);
}
