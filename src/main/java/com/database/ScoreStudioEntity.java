package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_studio", schema = "public", catalog = "postgres")
@IdClass(ScoreStudioEntityPK.class)
public class ScoreStudioEntity {
    private int idUserUs;
    private int idStudio;
    private float score;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_studio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
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
        ScoreStudioEntity that = (ScoreStudioEntity) o;
        return idUserUs == that.idUserUs &&
                idStudio == that.idStudio &&
                Float.compare(that.score, score) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idStudio, score);
    }
}
