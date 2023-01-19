package edu.miu.waarestful.repo;

import edu.miu.waarestful.entity.Post;

import java.util.List;
import java.util.UUID;

public interface PostRepo {
    public List<Post> findAll();

    public Post findById(UUID id);

    public void delete(UUID id);

    public void update(UUID id, Post p);

    public void save(Post post);
}

