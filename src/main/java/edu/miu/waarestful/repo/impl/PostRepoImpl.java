package edu.miu.waarestful.repo.impl;

import edu.miu.waarestful.entity.Post;
import edu.miu.waarestful.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fake")
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts = new ArrayList<>();

    static{
        posts.add(new Post(UUID.randomUUID(),"RESTful Services V1","Adopt RESTful services V1","Gebreegziabher Gebru"));
    }

    @Override
    public List<Post> findAll(){
        return posts;
    }

    @Override
    public Post findById(UUID id){
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(UUID id){
        Post post = findById(id);
        if(post != null)
            posts.remove(post);
    }

    @Override
    public void update(UUID id, Post p) {
        Post toUpdate = findById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getAuthor());
        toUpdate.setAuthor(p.getAuthor());
    }

    public void save(Post post){
        post.setId(UUID.randomUUID());
        posts.add(post);
    }
}
