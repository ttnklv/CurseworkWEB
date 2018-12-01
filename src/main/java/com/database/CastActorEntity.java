package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cast_actor", schema = "public", catalog = "postgres")
@IdClass(CastActorEntityPK.class)
public class CastActorEntity {
    private int idFilm;
    private int idActor;
    private ActorEntity actorByIdActor;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
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
        CastActorEntity that = (CastActorEntity) o;
        return idFilm == that.idFilm &&
                idActor == that.idActor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFilm, idActor);
    }

    @ManyToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor", nullable = false)
    public ActorEntity getActorByIdActor() {
        return actorByIdActor;
    }

    public void setActorByIdActor(ActorEntity actorByIdActor) {
        this.actorByIdActor = actorByIdActor;
    }
}
