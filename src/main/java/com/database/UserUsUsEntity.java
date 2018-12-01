package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_us_us", schema = "public", catalog = "postgres")
public class UserUsUsEntity {
    private int idUserUs;
    private CustomersEntity customersByIdUserUs;

    @Id
    @Column(name = "id_user_us", nullable = false)
    public int getIdUserUs() {
        return idUserUs;
    }

    public void setIdUserUs(int idUserUs) {
        this.idUserUs = idUserUs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUsUsEntity that = (UserUsUsEntity) o;
        return idUserUs == that.idUserUs;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserUs);
    }

    @OneToOne
    @JoinColumn(name = "id_user_us", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomersByIdUserUs() {
        return customersByIdUserUs;
    }

    public void setCustomersByIdUserUs(CustomersEntity customersByIdUserUs) {
        this.customersByIdUserUs = customersByIdUserUs;
    }
}
