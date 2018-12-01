package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "follower_actor", schema = "public", catalog = "postgres")
@IdClass(FollowerActorEntityPK.class)
public class FollowerActorEntity {
    private int idCustomers;
    private int idActor;
    private CustomersEntity customersByIdCustomers;
    private ActorEntity actorByIdActor;

    @Id
    @Column(name = "id_customers", nullable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
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
        FollowerActorEntity that = (FollowerActorEntity) o;
        return idCustomers == that.idCustomers &&
                idActor == that.idActor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomers, idActor);
    }

    @ManyToOne
    @JoinColumn(name = "id_customers", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomersByIdCustomers() {
        return customersByIdCustomers;
    }

    public void setCustomersByIdCustomers(CustomersEntity customersByIdCustomers) {
        this.customersByIdCustomers = customersByIdCustomers;
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
