package edu.miu.waarestful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private UUID id;
    private String title;
    private String content;
    private String author;
}