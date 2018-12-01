package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CastActorEntityPK implements Serializable {
    private int idFilm;
    private int idActor;

    @Column(name = "id_film", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
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
        CastActorEntityPK that = (CastActorEntityPK) o;
        return idFilm == that.idFilm &&
                idActor == that.idActor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFilm, idActor);
    }
}
