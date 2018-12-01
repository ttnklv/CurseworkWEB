package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "public", catalog = "postgres")
public class CustomersEntity {
    private int id;
    private String name;
    private String login;
    private String profileImageUrl;
    private String emailHash;
    private String password;
    private String mobNumber;
    private boolean reputation;
    private Date lastAccess;
    private int levelAccess;
    private byte[] img;
    private ActorEntity actorById;
    private AnalystEntity analystById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "login", nullable = false, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "profile_image_url", nullable = true, length = -1)
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Basic
    @Column(name = "email_hash", nullable = false, length = -1)
    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mob_number", nullable = false, length = 11)
    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Basic
    @Column(name = "reputation", nullable = false)
    public boolean isReputation() {
        return reputation;
    }

    public void setReputation(boolean reputation) {
        this.reputation = reputation;
    }

    @Basic
    @Column(name = "last_access", nullable = false)
    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Basic
    @Column(name = "level_access", nullable = false)
    public int getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(int levelAccess) {
        this.levelAccess = levelAccess;
    }

    @Basic
    @Column(name = "img", nullable = true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return id == that.id &&
                reputation == that.reputation &&
                levelAccess == that.levelAccess &&
                Objects.equals(name, that.name) &&
                Objects.equals(login, that.login) &&
                Objects.equals(profileImageUrl, that.profileImageUrl) &&
                Objects.equals(emailHash, that.emailHash) &&
                Objects.equals(password, that.password) &&
                Objects.equals(mobNumber, that.mobNumber) &&
                Objects.equals(lastAccess, that.lastAccess) &&
                Arrays.equals(img, that.img);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, login, profileImageUrl, emailHash, password, mobNumber, reputation, lastAccess, levelAccess);
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }

//    @OneToOne(mappedBy = "customersByIdActor")
//    public ActorEntity getActorById() {
//        return actorById;
//    }
//
//    public void setActorById(ActorEntity actorById) {
//        this.actorById = actorById;
//    }
//
//    @OneToOne(mappedBy = "customersByIdAnalyst")
//    public AnalystEntity getAnalystById() {
//        return analystById;
//    }

    public void setAnalystById(AnalystEntity analystById) {
        this.analystById = analystById;
    }
}
