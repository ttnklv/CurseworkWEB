package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "analyst", schema = "public", catalog = "postgres")
public class AnalystEntity {
    private int idAnalyst;
    private String aboutMe;
    private Long purse;

    @Id
    @Column(name = "id_analyst", nullable = false)
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalystEntity that = (AnalystEntity) o;
        return idAnalyst == that.idAnalyst &&
                Objects.equals(aboutMe, that.aboutMe) &&
                Objects.equals(purse, that.purse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAnalyst, aboutMe, purse);
    }
}
