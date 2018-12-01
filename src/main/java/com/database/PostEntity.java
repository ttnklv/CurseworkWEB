package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "public", catalog = "postgres")
public class PostEntity {
    private int id;
    private byte[] img;
    private Date createDate;
    private String body;
    private CustomersEntity customersByUserUsOwnerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "img", nullable = true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return id == that.id &&
                Arrays.equals(img, that.img) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, createDate, body);
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_us_owner_id", referencedColumnName = "id")
    public CustomersEntity getCustomersByUserUsOwnerId() {
        return customersByUserUsOwnerId;
    }

    public void setCustomersByUserUsOwnerId(CustomersEntity customersByUserUsOwnerId) {
        this.customersByUserUsOwnerId = customersByUserUsOwnerId;
    }
}
