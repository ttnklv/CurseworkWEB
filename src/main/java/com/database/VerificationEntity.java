package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "verification", schema = "public", catalog = "postgres")
@IdClass(VerificationEntityPK.class)
public class VerificationEntity {
    private int idCustomers;
    private int idStudio;
    private CustomersEntity customersByIdCustomers;
    private StudioEntity studioByIdStudio;

    @Id
    @Column(name = "id_customers", nullable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Id
    @Column(name = "id_studio", nullable = false)
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
        VerificationEntity that = (VerificationEntity) o;
        return idCustomers == that.idCustomers &&
                idStudio == that.idStudio;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomers, idStudio);
    }

//    @ManyToOne
//    @JoinColumn(name = "id_customers", referencedColumnName = "id", nullable = false)
//    public CustomersEntity getCustomersByIdCustomers() {
//        return customersByIdCustomers;
//    }
//
//    public void setCustomersByIdCustomers(CustomersEntity customersByIdCustomers) {
//        this.customersByIdCustomers = customersByIdCustomers;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_studio", referencedColumnName = "id_studio", nullable = false)
//    public StudioEntity getStudioByIdStudio() {
//        return studioByIdStudio;
//    }
//
//    public void setStudioByIdStudio(StudioEntity studioByIdStudio) {
//        this.studioByIdStudio = studioByIdStudio;
//    }
}
