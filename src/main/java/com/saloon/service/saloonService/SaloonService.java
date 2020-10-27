package com.saloon.service.saloonService;


import com.saloon.dto.Visitors;
import com.saloon.model.FreeTable;
import com.saloon.model.Saloon;
import com.saloon.repository.SaloonRepository;
import com.saloon.service.tableLeaving.TableLeavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public final class SaloonService implements InterfaceSaloonService {

    @Autowired
    private SaloonRepository saloonRepository;
    @Autowired
    private TableLeavingService tableLeavingService;


    public Saloon addSaloon(Saloon saloon) {
        FreeTable table = new FreeTable();
        table.setSaloonId(saloon.getTableId());
        saloon.setFreeTableId(table.getFreeTableId());
        Saloon savedSaloon = saloonRepository.save(saloon);
        table = tableLeavingService.addTable(table);
        return getById(savedSaloon.getTableId());
    }

    public List<Saloon> getAll() {
        return saloonRepository.findAll();
    }

    public Saloon getById(UUID id) {
        Saloon saloon = saloonRepository.findById(id).get();
        return saloon;
    }

    public Saloon getByPlaceNum(Visitors visitorsDto) {
        int placeNum = visitorsDto.getVisitorsNum();
        List<Saloon> tempSaloon = new ArrayList<>();
        for (Saloon t :
                saloonRepository.findAll()) {
            if (t.getPlaceNum() >= placeNum)
                tempSaloon.add(t);
        }
        List<FreeTable> tables = tableLeavingService.getAll();
        Saloon returnSaloon;
        for (FreeTable t :
                tables)
            for (Saloon s :
                    tempSaloon) {
                if (t.getSaloon().getTableId() == s.getTableId()) {
                    FreeTable table = t;
                    tableLeavingService.deleteById(table.getFreeTableId());
                     returnSaloon = getById(table.getSaloonId());
                    return returnSaloon;
                }
        return returnSaloon;
    }

    public void deleteSaloonById(UUID id) {
        Saloon saloon = saloonRepository.findById(id).get();
        tableLeavingService.deleteById(saloon.getFreeTableId());
        saloonRepository.deleteById(id);
    }
}
