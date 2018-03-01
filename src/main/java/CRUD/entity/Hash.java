package CRUD.entity;

import javax.persistence.*;

@Entity
@Table(name = "hash")
public class Hash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Hash(String hash, int id) {
        this.hash = hash;
        this.id = id;
    }

    public Hash() {

    }

    @Column(name = "hash")
    private String hash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
