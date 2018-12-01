package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_actor", schema = "public", catalog = "postgres")
@IdClass(ScoreActorEntityPK.class)
public class ScoreActorEntity {
    private int idUserUs;
    private int idActor;
    private float score;
    private ActorEntity actorByIdActor;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
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
        ScoreActorEntity that = (ScoreActorEntity) o;
        return idUserUs == that.idUserUs &&
                idActor == that.idActor &&
                Float.compare(that.score, score) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs, idActor, score);
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
