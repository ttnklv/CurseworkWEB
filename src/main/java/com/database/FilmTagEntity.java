package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_tag", schema = "public", catalog = "postgres")
@IdClass(FilmTagEntityPK.class)
public class FilmTagEntity {
    private int idTag;
    private int idFilm;
    private FilmEntity filmByIdFilm;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTagEntity that = (FilmTagEntity) o;
        return idTag == that.idTag &&
                idFilm == that.idFilm;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, idFilm);
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
