package com.immplah.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class SideEffect implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    private String name;

    @ManyToMany
    @JoinTable(name = "drug_side_effect",
    joinColumns = @JoinColumn(name="side_effect_id"),
    inverseJoinColumns = @JoinColumn(name="drug_id"))
    private List<Drug> drugs;

    public SideEffect() {

    }

    public SideEffect(String name, List<Drug> drugs) {
        this.name = name;
        this.drugs = drugs;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
