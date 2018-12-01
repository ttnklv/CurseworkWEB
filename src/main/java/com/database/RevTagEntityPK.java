package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RevTagEntityPK implements Serializable {
    private int idTag;
    private int idReview;

    @Column(name = "id_tag", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Column(name = "id_review", nullable = false, insertable = false, updatable = false)
    @Id
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
        RevTagEntityPK that = (RevTagEntityPK) o;
        return idTag == that.idTag &&
                idReview == that.idReview;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, idReview);
    }
}
