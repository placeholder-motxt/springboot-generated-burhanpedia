package com.example.burhanpedia.controller;

import com.example.burhanpedia.model.Pembeli;
import com.example.burhanpedia.service.PembeliService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
@RequiredArgsConstructor
public class PembeliController {

    private final PembeliService pembeliService;

    @PostMapping
    @Operation(summary = "Create a new pembeli")
    public Pembeli createPembeli(@RequestBody Pembeli pembeli) {
        return pembeliService.createPembeli(pembeli);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get pembeli by ID")
    public Pembeli getPembeli(@PathVariable String id) {
        return pembeliService.getPembeli(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update pembeli by ID")
    public Pembeli updatePembeli(@RequestBody Pembeli pembeli, @PathVariable String id) {
        return pembeliService.updatePembeli(pembeli, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete pembeli by ID")
    public void deletePembeli(@PathVariable String id) {
        pembeliService.deletePembeli(id);
    }
}
