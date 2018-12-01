package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "system", schema = "public", catalog = "postgres")
public class SystemEntity {
    private int id;
    private String name;
    private String body;
    private String adminMail;

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
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "admin_mail", nullable = false, length = -1)
    public String getAdminMail() {
        return adminMail;
    }

    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEntity that = (SystemEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(body, that.body) &&
                Objects.equals(adminMail, that.adminMail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, body, adminMail);
    }
}
