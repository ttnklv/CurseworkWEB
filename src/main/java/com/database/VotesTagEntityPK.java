package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class VotesTagEntityPK implements Serializable {
    private int idTag;
    private int idVotes;

    @Column(name = "id_tag", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Column(name = "id_votes", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdVotes() {
        return idVotes;
    }

    public void setIdVotes(int idVotes) {
        this.idVotes = idVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotesTagEntityPK that = (VotesTagEntityPK) o;
        return idTag == that.idTag &&
                idVotes == that.idVotes;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, idVotes);
    }
}
