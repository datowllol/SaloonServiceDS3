package com.saloon.service.saloonService;


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
        table.setSaloon(saloon);
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

    public List<Saloon> getByPlaceNum(Integer placeNum) {
        List<Saloon> enoughPlaceSaloon = new ArrayList<>();
        for (Saloon t :
                saloonRepository.findAll()) {
            if (t.getPlaceNum() >= placeNum)
                enoughPlaceSaloon.add(t);
        }
        return enoughPlaceSaloon;
    }

    public void deleteSaloonById(UUID id) {
        Saloon saloon = saloonRepository.findById(id).get();
        tableLeavingService.deleteById(saloon.getFreeTable().getFreeTableId());
        saloonRepository.deleteById(id);
    }
}
