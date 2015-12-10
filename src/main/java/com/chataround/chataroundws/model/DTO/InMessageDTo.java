package com.chataround.chataroundws.model.DTO;

/**
 * @author Georgia Grigoriadou
 */
public class InMessageDTO {
    Long id;
    String content;
    Double radius;

    public InMessageDTO() {
    }

    public InMessageDTO(Long id, String content, Double radius) {
        this.id = id;
        this.content = content;
        this.radius = radius;
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

    public Double getRadious() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
