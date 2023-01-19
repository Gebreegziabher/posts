package edu.miu.waarestful.service.impl;

import edu.miu.waarestful.entity.dto.PostDto;
import edu.miu.waarestful.entity.Post;
import edu.miu.waarestful.repo.PostRepo;
import edu.miu.waarestful.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepo repo;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public List<PostDto> findAll() {
        return repo.findAll()
                .stream()
                .map( p -> modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto findById(UUID id){
        return modelMapper.map(repo.findById(id), PostDto.class);
    }

    public void save(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        repo.save(post);
    }

    @Override
    public void update(UUID id,  PostDto p) {
        repo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(UUID id) {
        repo.delete(id);
    }
}
