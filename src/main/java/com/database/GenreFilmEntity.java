package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genre_film", schema = "public", catalog = "postgres")
@IdClass(GenreFilmEntityPK.class)
public class GenreFilmEntity {
    private int idFilm;
    private int idGenre;
    private FilmEntity filmByIdFilm;
    private GenreEntity genreByIdGenre;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_genre", nullable = false)
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
        GenreFilmEntity that = (GenreFilmEntity) o;
        return idFilm == that.idFilm &&
                idGenre == that.idGenre;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFilm, idGenre);
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilmByIdFilm() {
        return filmByIdFilm;
    }

    public void setFilmByIdFilm(FilmEntity filmByIdFilm) {
        this.filmByIdFilm = filmByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "id_genre", referencedColumnName = "id", nullable = false)
    public GenreEntity getGenreByIdGenre() {
        return genreByIdGenre;
    }

    public void setGenreByIdGenre(GenreEntity genreByIdGenre) {
        this.genreByIdGenre = genreByIdGenre;
    }
}
