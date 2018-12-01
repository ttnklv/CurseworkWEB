package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TransactionEntityPK implements Serializable {
    private int idSender;
    private int idRecipient;

    @Column(name = "id_sender", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Column(name = "id_recipient", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntityPK that = (TransactionEntityPK) o;
        return idSender == that.idSender &&
                idRecipient == that.idRecipient;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSender, idRecipient);
    }
}
