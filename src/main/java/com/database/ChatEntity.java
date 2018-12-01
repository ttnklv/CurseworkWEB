package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "public", catalog = "postgres")
public class ChatEntity {
    private int id;
    private Integer filmId;
    private String msg;
    private Integer userUsId;
    private Date createDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "film_id", nullable = true)
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "msg", nullable = false, length = -1)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "user_us_id", nullable = true)
    public Integer getUserUsId() {
        return userUsId;
    }

    public void setUserUsId(Integer userUsId) {
        this.userUsId = userUsId;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return id == that.id &&
                Objects.equals(filmId, that.filmId) &&
                Objects.equals(msg, that.msg) &&
                Objects.equals(userUsId, that.userUsId) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, filmId, msg, userUsId, createDate);
    }
}
