package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScoreAnalystEntityPK implements Serializable {
    private int idUserUs;
    private int idAnalyst;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Column(name = "id_analyst", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreAnalystEntityPK that = (ScoreAnalystEntityPK) o;
        return idUserUs == that.idUserUs &&
                idAnalyst == that.idAnalyst;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idAnalyst);
    }
}
