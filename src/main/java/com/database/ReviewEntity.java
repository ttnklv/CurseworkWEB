package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "public", catalog = "postgres")
public class ReviewEntity {
    private int idAnalyst;
    private String body;
    private AnalystEntity analystByIdAnalyst;
    private FilmEntity filmByIdFilm;

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Basic
    @Column(name = "body", nullable = true, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return idAnalyst == that.idAnalyst &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAnalyst, body);
    }

    @OneToOne
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalystByIdAnalyst() {
        return analystByIdAnalyst;
    }

    public void setAnalystByIdAnalyst(AnalystEntity analystByIdAnalyst) {
        this.analystByIdAnalyst = analystByIdAnalyst;
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
