package com.chataround.chataroundws.model.DTO;

/**
 * @author Georgia Grigoriadou
 */
public class OutMessageDTO {
    String username;
    String content;

    public OutMessageDTO() {
    }

    public OutMessageDTO(String username, String content)
    {
        this.username=username;
        this.content = content;
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
