package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor", schema = "public", catalog = "postgres")
public class ActorEntity {
    private int idActor;
    private String aboutMe;

    @Id
    @Column(name = "id_actor", nullable = false)
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Basic
    @Column(name = "about_me", nullable = true, length = -1)
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEntity that = (ActorEntity) o;
        return idActor == that.idActor &&
                Objects.equals(aboutMe, that.aboutMe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idActor, aboutMe);
    }
}
