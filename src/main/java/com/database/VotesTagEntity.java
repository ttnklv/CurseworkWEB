package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "votes_tag", schema = "public", catalog = "postgres")
@IdClass(VotesTagEntityPK.class)
public class VotesTagEntity {
    private int idTag;
    private int idVotes;
    private TagEntity tagByIdTag;
    private VotesEntity votesByIdVotes;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_votes", nullable = false)
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
        VotesTagEntity that = (VotesTagEntity) o;
        return idTag == that.idTag &&
                idVotes == that.idVotes;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, idVotes);
    }

    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id", nullable = false)
    public TagEntity getTagByIdTag() {
        return tagByIdTag;
    }

    public void setTagByIdTag(TagEntity tagByIdTag) {
        this.tagByIdTag = tagByIdTag;
    }

    @ManyToOne
    @JoinColumn(name = "id_votes", referencedColumnName = "id", nullable = false)
    public VotesEntity getVotesByIdVotes() {
        return votesByIdVotes;
    }

    public void setVotesByIdVotes(VotesEntity votesByIdVotes) {
        this.votesByIdVotes = votesByIdVotes;
    }
}
