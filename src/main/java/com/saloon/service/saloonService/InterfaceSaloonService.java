package com.saloon.service.saloonService;



import com.saloon.model.Saloon;

import java.util.List;
import java.util.UUID;

public interface InterfaceSaloonService {

    Saloon addSaloon(Saloon saloon);

    List<Saloon> getAll();

    Saloon getById(UUID id);

    List<Saloon> getByPlaceNum(Integer placeNum);

    void deleteSaloonById(UUID id);
}
