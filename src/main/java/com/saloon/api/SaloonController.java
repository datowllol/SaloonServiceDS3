package com.saloon.api;


import com.saloon.model.Saloon;
import com.saloon.service.saloonService.SaloonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/saloon")
@AllArgsConstructor
@NoArgsConstructor
public class SaloonController {
    @Autowired
    SaloonService saloonService;

    @PostMapping()
    public Saloon addSaloon(@RequestBody Saloon saloon) {
        return saloonService.addSaloon(saloon);
    }


    @GetMapping()
    public List<Saloon> getAll() {
        return saloonService.getAll();
    }

    @GetMapping("/{tableID}")
    public Saloon getById(@PathVariable(value = "tableID") UUID id) {
        return saloonService.getById(id);
    }

    @DeleteMapping("/{tableID}")
    public ResponseEntity<Void> deleteSaloonById(@PathVariable(value = "tableID") UUID id) {
        saloonService.deleteSaloonById(id);
        return ResponseEntity.noContent().build();
    }
}