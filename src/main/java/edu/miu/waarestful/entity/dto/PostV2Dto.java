package edu.miu.waarestful.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PostV2Dto {
    private UUID id;
    private String title;
    private String content;
    private String author;
}
