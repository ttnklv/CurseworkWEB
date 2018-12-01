package com.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "studio", schema = "public", catalog = "postgres")
public class StudioEntity {
    private int idStudio;
    private String aboutMe;
    private Long purse;
    private byte[] logoImg;
    private CustomersEntity customersByIdStudio;

    @Id
    @Column(name = "id_studio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Basic
    @Column(name = "about_me", nullable = true, length = -1)
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Basic
    @Column(name = "purse", nullable = true)
    public Long getPurse() {
        return purse;
    }

    public void setPurse(Long purse) {
        this.purse = purse;
    }

    @Basic
    @Column(name = "logo_img", nullable = true)
    public byte[] getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(byte[] logoImg) {
        this.logoImg = logoImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudioEntity that = (StudioEntity) o;
        return idStudio == that.idStudio &&
                Objects.equals(aboutMe, that.aboutMe) &&
                Objects.equals(purse, that.purse) &&
                Arrays.equals(logoImg, that.logoImg);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(idStudio, aboutMe, purse);
        result = 31 * result + Arrays.hashCode(logoImg);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_studio", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomersByIdStudio() {
        return customersByIdStudio;
    }

    public void setCustomersByIdStudio(CustomersEntity customersByIdStudio) {
        this.customersByIdStudio = customersByIdStudio;
    }
}
