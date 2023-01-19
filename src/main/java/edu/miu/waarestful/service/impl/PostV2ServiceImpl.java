package edu.miu.waarestful.service.impl;
import edu.miu.waarestful.entity.PostV2;
import edu.miu.waarestful.entity.dto.PostV2Dto;
import edu.miu.waarestful.repo.PostRepo;
import edu.miu.waarestful.repo.PostV2Repo;
import edu.miu.waarestful.service.PostV2Service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostV2ServiceImpl implements PostV2Service {
    private PostV2Repo repo;

    private ModelMapper modelMapper;

    public PostV2ServiceImpl(PostV2Repo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public List<PostV2Dto> findAll() {
        return repo.findAll()
                .stream()
                .map( p -> modelMapper.map(p,PostV2Dto.class))
                .collect(Collectors.toList());
    }

    public PostV2Dto findById(UUID id){
        return modelMapper.map(repo.findById(id), PostV2Dto.class);
    }

    public void save(PostV2Dto postDto){
        PostV2 post = modelMapper.map(postDto, PostV2.class);
        repo.save(post);
    }

    @Override
    public void update(UUID id,  PostV2Dto p) {
        repo.update(id, modelMapper.map(p, PostV2.class));
    }

    @Override
    public void delete(UUID id) {
        repo.delete(id);
    }
}
