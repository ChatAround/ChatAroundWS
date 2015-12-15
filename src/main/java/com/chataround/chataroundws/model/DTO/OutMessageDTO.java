package com.chataround.chataroundws.model.DTO;

/**
 * @author Georgia Grigoriadou
 */
public class OutMessageDTO {
    Long id;
    String username;
    String content;

    public OutMessageDTO() {
    }

    public OutMessageDTO(Long id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
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
}
