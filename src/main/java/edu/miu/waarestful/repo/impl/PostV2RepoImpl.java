package edu.miu.waarestful.repo.impl;

import edu.miu.waarestful.entity.Post;
import edu.miu.waarestful.entity.PostV2;
import edu.miu.waarestful.repo.PostRepo;
import edu.miu.waarestful.repo.PostV2Repo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fake-v2")
public class PostV2RepoImpl implements PostV2Repo {

    private static List<PostV2> posts = new ArrayList<>();

    static{
        posts.add(new PostV2(UUID.randomUUID(),"RESTful Services V2","Adopt RESTful services V2","Hailemelekot Mamo"));
    }

    @Override
    public List<PostV2> findAll(){
        return posts;
    }

    @Override
    public PostV2 findById(UUID id){
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(UUID id){
        PostV2 post = findById(id);
        if(post != null)
            posts.remove(post);
    }

    @Override
    public void update(UUID id, PostV2 p) {
        PostV2 toUpdate = findById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getAuthor());
        toUpdate.setAuthor(p.getAuthor());
    }

    public void save(PostV2 post){
        post.setId(UUID.randomUUID());
        posts.add(post);
    }
}
