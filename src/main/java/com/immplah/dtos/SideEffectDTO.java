package com.immplah.dtos;

import com.immplah.entities.Drug;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

public class SideEffectDTO extends RepresentationModel<SideEffectDTO> {

    private UUID id;
    private String name;

    public SideEffectDTO() {
    }

    public SideEffectDTO(UUID id, String name) {
        this.id = id;
        this.name = name;

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


}
