package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostTagEntityPK implements Serializable {
    private int idPost;
    private int idTag;

    @Column(name = "id_post", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Column(name = "id_tag", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagEntityPK that = (PostTagEntityPK) o;
        return idPost == that.idPost &&
                idTag == that.idTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPost, idTag);
    }
}
