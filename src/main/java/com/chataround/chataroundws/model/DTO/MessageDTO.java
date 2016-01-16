package com.chataround.chataroundws.model.DTO;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Gewrgia
 */
public class MessageDTO{

    private Long id;
    @NotNull
    private String username;
    @NotNull
    @Size (min=1,max=150)
    private String content;
    @NotNull
    Double radius;
    @NotNull
    int duration;


    public MessageDTO() {
    }

    public MessageDTO(Long id,String username, String content, Double radius,int duration) {
        this.id=id;
        this.username = username;
        this.content = content;
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
}

