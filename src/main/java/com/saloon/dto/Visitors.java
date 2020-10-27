package com.saloon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
public final class Visitors {


    private UUID visitorId;
    private int visitorsNum;
    private UUID occupiedTableID;


    public Visitors() {
        visitorId = UUID.randomUUID();
    }

}