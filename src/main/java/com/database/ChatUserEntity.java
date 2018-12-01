package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chat_user", schema = "public", catalog = "postgres")
public class ChatUserEntity {
    private int id;
    private ChatEntity chatByIdChat;
    private Integer idUs;
    private Integer idChat;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatUserEntity that = (ChatUserEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "id_chat", referencedColumnName = "id", updatable = false , insertable = false)
    public ChatEntity getChatByIdChat() {
        return chatByIdChat;
    }

    public void setChatByIdChat(ChatEntity chatByIdChat) {
        this.chatByIdChat = chatByIdChat;
    }

    @Basic
    @Column(name = "id_us", nullable = true)
    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    @Basic
    @Column(name = "id_chat", nullable = true)
    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }
}
