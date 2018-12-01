package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_analyst", schema = "public", catalog = "postgres")
@IdClass(ScoreAnalystEntityPK.class)
public class ScoreAnalystEntity {
    private int idUserUs;
    private int idAnalyst;
    private float score;
    private AnalystEntity analystByIdAnalyst;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
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
        ScoreAnalystEntity that = (ScoreAnalystEntity) o;
        return idUserUs == that.idUserUs &&
                idAnalyst == that.idAnalyst &&
                Float.compare(that.score, score) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idAnalyst, score);
    }

    @ManyToOne
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalystByIdAnalyst() {
        return analystByIdAnalyst;
    }

    public void setAnalystByIdAnalyst(AnalystEntity analystByIdAnalyst) {
        this.analystByIdAnalyst = analystByIdAnalyst;
    }
}
