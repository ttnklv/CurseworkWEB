package com.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "gallery_actor", schema = "public", catalog = "postgres")
public class GalleryActorEntity {
    private int id;
    private byte[] photo;
    private ActorEntity actorByIdActor;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GalleryActorEntity that = (GalleryActorEntity) o;
        return id == that.id &&
                Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor")
    public ActorEntity getActorByIdActor() {
        return actorByIdActor;
    }

    public void setActorByIdActor(ActorEntity actorByIdActor) {
        this.actorByIdActor = actorByIdActor;
    }
}
