package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "script", schema = "public", catalog = "postgres")
@IdClass(ScriptEntityPK.class)
public class ScriptEntity {
    private int idFilm;
    private int idStudio;
    private FilmEntity filmByIdFilm;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_studio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptEntity that = (ScriptEntity) o;
        return idFilm == that.idFilm &&
                idStudio == that.idStudio;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFilm, idStudio);
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
