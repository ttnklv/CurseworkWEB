package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "follower_analyst", schema = "public", catalog = "postgres")
@IdClass(FollowerAnalystEntityPK.class)
public class FollowerAnalystEntity {
    private int idCustomers;
    private int idAnalyst;
    private CustomersEntity customersByIdCustomers;
    private AnalystEntity analystByIdAnalyst;

    @Id
    @Column(name = "id_customers", nullable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowerAnalystEntity that = (FollowerAnalystEntity) o;
        return idCustomers == that.idCustomers &&
                idAnalyst == that.idAnalyst;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomers, idAnalyst);
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
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalystByIdAnalyst() {
        return analystByIdAnalyst;
    }

    public void setAnalystByIdAnalyst(AnalystEntity analystByIdAnalyst) {
        this.analystByIdAnalyst = analystByIdAnalyst;
    }
}
