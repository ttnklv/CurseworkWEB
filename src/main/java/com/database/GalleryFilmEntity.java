package com.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "gallery_film", schema = "public", catalog = "postgres")
public class GalleryFilmEntity {
    private int id;
    private byte[] photo;
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
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GalleryFilmEntity that = (GalleryFilmEntity) o;
        return id == that.id &&
                Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(photo);
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
