package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScoreActorEntityPK implements Serializable {
    private int idUserUs;
    private int idActor;

    @Column(name = "id_user_us", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Column(name = "id_actor", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreActorEntityPK that = (ScoreActorEntityPK) o;
        return idUserUs == that.idUserUs &&
                idActor == that.idActor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idActor);
    }
}
