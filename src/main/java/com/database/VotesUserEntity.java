package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "votes_user", schema = "public", catalog = "postgres")
@IdClass(VotesUserEntityPK.class)
public class VotesUserEntity {
    private int idVotes;
    private int idUser;
    private VotesEntity votesByIdVotes;
    private UserUsUsEntity userUsUsByIdUser;

    @Id
    @Column(name = "id_votes", nullable = false)
    public int getIdVotes() {
        return idVotes;
    }

    public void setIdVotes(int idVotes) {
        this.idVotes = idVotes;
    }

    @Id
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotesUserEntity that = (VotesUserEntity) o;
        return idVotes == that.idVotes &&
                idUser == that.idUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVotes, idUser);
    }

    @ManyToOne
    @JoinColumn(name = "id_votes", referencedColumnName = "id", nullable = false)
    public VotesEntity getVotesByIdVotes() {
        return votesByIdVotes;
    }

    public void setVotesByIdVotes(VotesEntity votesByIdVotes) {
        this.votesByIdVotes = votesByIdVotes;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user_us", nullable = false)
    public UserUsUsEntity getUserUsUsByIdUser() {
        return userUsUsByIdUser;
    }

    public void setUserUsUsByIdUser(UserUsUsEntity userUsUsByIdUser) {
        this.userUsUsByIdUser = userUsUsByIdUser;
    }
}
