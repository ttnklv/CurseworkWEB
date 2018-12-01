package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScoreStudioEntityPK implements Serializable {
    private int idUserUs;
    private int idStudio;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Column(name = "id_studio", nullable = false, insertable = false, updatable = false)
    @Id
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
        ScoreStudioEntityPK that = (ScoreStudioEntityPK) o;
        return idUserUs == that.idUserUs &&
                idStudio == that.idStudio;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idStudio);
    }
}
