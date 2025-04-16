package com.example.burhanpedia.controller;

import com.example.burhanpedia.model.Penjual;
import com.example.burhanpedia.service.PenjualService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/penjual")
@RequiredArgsConstructor
public class PenjualController {

    private final PenjualService penjualService;

    @PostMapping
    @Operation(summary = "Create a new penjual")
    public Penjual createPenjual(@RequestBody Penjual penjual) {
        return penjualService.createPenjual(penjual);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a penjual by ID")
    public Penjual getPenjual(@PathVariable String id) {
        return penjualService.getPenjual(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing penjual")
    public Penjual updatePenjual(@RequestBody Penjual penjual, @PathVariable String id) {
        return penjualService.updatePenjual(penjual, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a penjual by ID")
    public void deletePenjual(@PathVariable String id) {
        penjualService.deletePenjual(id);
    }
}
