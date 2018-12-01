package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GenreFilmEntityPK implements Serializable {
    private int idFilm;
    private int idGenre;

    @Column(name = "id_film", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Column(name = "id_genre", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreFilmEntityPK that = (GenreFilmEntityPK) o;
        return idFilm == that.idFilm &&
                idGenre == that.idGenre;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFilm, idGenre);
    }
}
