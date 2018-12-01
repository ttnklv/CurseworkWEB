package com.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "votes", schema = "public", catalog = "postgres")
public class VotesEntity {
    private int id;
    private Integer countPositive;
    private Integer countNegative;
    private String name;
    private Boolean flagAccess;
    private byte[] votesImageUrl;
    private FilmEntity filmByIdFilm;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "count_positive", nullable = true)
    public Integer getCountPositive() {
        return countPositive;
    }

    public void setCountPositive(Integer countPositive) {
        this.countPositive = countPositive;
    }

    @Basic
    @Column(name = "count_negative", nullable = true)
    public Integer getCountNegative() {
        return countNegative;
    }

    public void setCountNegative(Integer countNegative) {
        this.countNegative = countNegative;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "flag_access", nullable = true)
    public Boolean getFlagAccess() {
        return flagAccess;
    }

    public void setFlagAccess(Boolean flagAccess) {
        this.flagAccess = flagAccess;
    }

    @Basic
    @Column(name = "votes_image_url", nullable = true)
    public byte[] getVotesImageUrl() {
        return votesImageUrl;
    }

    public void setVotesImageUrl(byte[] votesImageUrl) {
        this.votesImageUrl = votesImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotesEntity that = (VotesEntity) o;
        return id == that.id &&
                Objects.equals(countPositive, that.countPositive) &&
                Objects.equals(countNegative, that.countNegative) &&
                Objects.equals(name, that.name) &&
                Objects.equals(flagAccess, that.flagAccess) &&
                Arrays.equals(votesImageUrl, that.votesImageUrl);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, countPositive, countNegative, name, flagAccess);
        result = 31 * result + Arrays.hashCode(votesImageUrl);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    public FilmEntity getFilmByIdFilm() {
        return filmByIdFilm;
    }

    public void setFilmByIdFilm(FilmEntity filmByIdFilm) {
        this.filmByIdFilm = filmByIdFilm;
    }
}
