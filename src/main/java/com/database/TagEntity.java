package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tag", schema = "public", catalog = "postgres")
public class TagEntity {
    private int id;
    private String tagName;
    private int count;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tag_name", nullable = false, length = -1)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return id == tagEntity.id &&
                count == tagEntity.count &&
                Objects.equals(tagName, tagEntity.tagName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tagName, count);
    }
}
