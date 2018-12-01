package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rev_tag", schema = "public", catalog = "postgres")
@IdClass(RevTagEntityPK.class)
public class RevTagEntity {
    private int idTag;
    private int idReview;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_review", nullable = false)
    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevTagEntity that = (RevTagEntity) o;
        return idTag == that.idTag &&
                idReview == that.idReview;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, idReview);
    }
}
