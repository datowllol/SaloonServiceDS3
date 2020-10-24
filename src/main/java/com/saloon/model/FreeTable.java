package com.saloon.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public final class FreeTable {

    @Id
    private UUID freeTableId;
    @Column
    private UUID saloonId;

    public FreeTable(){
        freeTableId = UUID.randomUUID();
    }

}