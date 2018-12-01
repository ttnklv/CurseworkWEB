package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FollowerStudioEntityPK implements Serializable {
    private int idCustomers;
    private int idStudio;

    @Column(name = "id_customers", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
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
        FollowerStudioEntityPK that = (FollowerStudioEntityPK) o;
        return idCustomers == that.idCustomers &&
                idStudio == that.idStudio;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomers, idStudio);
    }
}
