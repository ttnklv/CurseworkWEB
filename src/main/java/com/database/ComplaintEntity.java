package com.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "complaint", schema = "public", catalog = "postgres")
public class ComplaintEntity {
    private int id;
    private String body;
    private String answer;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "answer", nullable = true, length = -1)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplaintEntity that = (ComplaintEntity) o;
        return id == that.id &&
                Objects.equals(body, that.body) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, body, answer);
    }
}
