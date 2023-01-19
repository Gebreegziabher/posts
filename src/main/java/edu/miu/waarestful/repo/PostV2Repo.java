package edu.miu.waarestful.repo;

import edu.miu.waarestful.entity.Post;
import edu.miu.waarestful.entity.PostV2;

import java.util.List;
import java.util.UUID;

public interface PostV2Repo {
    public List<PostV2> findAll();

    public PostV2 findById(UUID id);

    public void delete(UUID id);

    public void update(UUID id, PostV2 p);

    public void save(PostV2 post);
}

