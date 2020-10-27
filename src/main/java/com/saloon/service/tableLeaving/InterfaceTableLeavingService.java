package com.saloon.service.tableLeaving;


import com.saloon.model.FreeTable;

import java.util.List;
import java.util.UUID;

public interface InterfaceTableLeavingService  {
    FreeTable addTable(FreeTable table);
    List<FreeTable> getAll();
    FreeTable getById(UUID id);
    FreeTable setFree(FreeTable table);
    public void deleteById(UUID id);
}
