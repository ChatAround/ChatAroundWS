package com.chataround.chataroundws.model.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Georgia Grigoriadou
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=4, max = 16)
    private String username;
    @NotNull
    @Size(min=1, max = 150)
    private String content;
    @Transient
    private MultipartFile file;
    @NotNull
    Double radius;
    @NotNull
    int duration;


    public Message() {
    }
    public Message(String username, String content, Double radius, int duration) {
        this.username = username;
        this.content = content;
        this.radius = radius;
        this.duration=duration;
    }

    public Message(String username, String content,MultipartFile file, Double radius, int duration) {
        this.username = username;
        this.content = content;
        this.file =file;
        this.radius = radius;
        this.duration=duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
