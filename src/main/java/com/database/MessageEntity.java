package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "public", catalog = "postgres")
public class MessageEntity {
    private int idAnalyst;
    private String body;
    private Date createDate;
    private AnalystEntity analystByIdAnalyst;

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return idAnalyst == that.idAnalyst &&
                Objects.equals(body, that.body) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAnalyst, body, createDate);
    }

    @OneToOne
    @JoinColumn(name = "id_analyst", referencedColumnName = "id_analyst", nullable = false)
    public AnalystEntity getAnalystByIdAnalyst() {
        return analystByIdAnalyst;
    }

    public void setAnalystByIdAnalyst(AnalystEntity analystByIdAnalyst) {
        this.analystByIdAnalyst = analystByIdAnalyst;
    }
}
