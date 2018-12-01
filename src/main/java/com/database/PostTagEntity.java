package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_tag", schema = "public", catalog = "postgres")
@IdClass(PostTagEntityPK.class)
public class PostTagEntity {
    private int idPost;
    private int idTag;
    private PostEntity postByIdPost;

    @Id
    @Column(name = "id_post", nullable = false)
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Id
    @Column(name = "id_tag", nullable = false)
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
        PostTagEntity that = (PostTagEntity) o;
        return idPost == that.idPost &&
                idTag == that.idTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPost, idTag);
    }

    @ManyToOne
    @JoinColumn(name = "id_post", referencedColumnName = "id", nullable = false)
    public PostEntity getPostByIdPost() {
        return postByIdPost;
    }

    public void setPostByIdPost(PostEntity postByIdPost) {
        this.postByIdPost = postByIdPost;
    }
}
