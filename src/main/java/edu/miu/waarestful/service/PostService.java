package edu.miu.waarestful.service;

import edu.miu.waarestful.entity.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto findById(UUID id);

    public void delete(UUID id);
    public void save(PostDto postDto);
    public void update(UUID id, PostDto postDto);
}
