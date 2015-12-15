package com.chataround.chataroundws.model.DTO;

/**
 * @author Georgia Grigoriadou
 */
public class InMessageDTO {
    Long id;
    String content;
    Double radius;
    int duration;

    public InMessageDTO() {
    }

    public InMessageDTO(Long id, String content, Double radius, int duration) {
        this.id = id;
        this.content = content;
        this.radius = radius;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
