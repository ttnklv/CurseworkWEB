package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction", schema = "public", catalog = "postgres")
@IdClass(TransactionEntityPK.class)
public class TransactionEntity {
    private int idSender;
    private int idRecipient;
    private long sum;
    private StudioEntity studioByIdSender;
    private AnalystEntity analystByIdRecipient;

    @Id
    @Column(name = "id_sender", nullable = false)
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Id
    @Column(name = "id_recipient", nullable = false)
    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Basic
    @Column(name = "sum", nullable = false)
    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return idSender == that.idSender &&
                idRecipient == that.idRecipient &&
                sum == that.sum;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSender, idRecipient, sum);
    }

//    @ManyToOne
//    @JoinColumn(name = "id_sender", referencedColumnName = "id_studio", nullable = false)
//    public StudioEntity getStudioByIdSender() {
//        return studioByIdSender;
//    }
//
//    public void setStudioByIdSender(StudioEntity studioByIdSender) {
//        this.studioByIdSender = studioByIdSender;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_recipient", referencedColumnName = "id_analyst", nullable = false)
//    public AnalystEntity getAnalystByIdRecipient() {
//        return analystByIdRecipient;
//    }
//
//    public void setAnalystByIdRecipient(AnalystEntity analystByIdRecipient) {
//        this.analystByIdRecipient = analystByIdRecipient;
//    }
}
