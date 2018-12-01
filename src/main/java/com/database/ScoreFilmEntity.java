package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_film", schema = "public", catalog = "postgres")
@IdClass(ScoreFilmEntityPK.class)
public class ScoreFilmEntity {
    private int idUserUs;
    private int idFilm;
    private float score;
    private FilmEntity filmByIdFilm;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "score", nullable = false, precision = 0)
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreFilmEntity that = (ScoreFilmEntity) o;
        return idUserUs == that.idUserUs &&
                idFilm == that.idFilm &&
                Float.compare(that.score, score) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idFilm, score);
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilmByIdFilm() {
        return filmByIdFilm;
    }

    public void setFilmByIdFilm(FilmEntity filmByIdFilm) {
        this.filmByIdFilm = filmByIdFilm;
    }
}
