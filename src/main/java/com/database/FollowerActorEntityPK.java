package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FollowerActorEntityPK implements Serializable {
    private int idCustomers;
    private int idActor;

    @Column(name = "id_customers", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
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
        FollowerActorEntityPK that = (FollowerActorEntityPK) o;
        return idCustomers == that.idCustomers &&
                idActor == that.idActor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomers, idActor);
    }
}
