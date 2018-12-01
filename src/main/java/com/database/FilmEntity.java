package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "public", catalog = "postgres")
public class FilmEntity {
    private int id;
    private String name;
    private Date createDate;
    private String body;
    private byte[] img;
    private Integer cashbox;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "body", nullable = true, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "img", nullable = true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Basic
    @Column(name = "cashbox", nullable = true)
    public Integer getCashbox() {
        return cashbox;
    }

    public void setCashbox(Integer cashbox) {
        this.cashbox = cashbox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(body, that.body) &&
                Arrays.equals(img, that.img) &&
                Objects.equals(cashbox, that.cashbox);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, createDate, body, cashbox);
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }
}
