package com.example.burhanpedia.service;

import com.example.burhanpedia.model.Penjual;
import com.example.burhanpedia.repository.PenjualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PenjualService {

    private final PenjualRepository penjualRepository;

    // Create Penjual
    public Penjual createPenjual(Penjual penjual) {
        return penjualRepository.save(penjual);
    }

    // Get Penjual by id
    public Penjual getPenjual(String id) {
        return penjualRepository.findById(id).orElse(null);  // Return null if not found
    }

    // Update Penjual by id
    public Penjual updatePenjual(Penjual penjual, String id) {
        Penjual existingPenjual = penjualRepository.findById(id).orElse(null);

        if (existingPenjual != null) {
            existingPenjual.setNamaToko(penjual.getNamaToko());
            existingPenjual.setUsername(penjual.getUsername());
            return penjualRepository.save(existingPenjual);  // Save the updated penjual
        } else {
            throw new RuntimeException("Penjual not found for id: " + id);
        }
    }

    // Delete Penjual by id
    @Transactional
    public void deletePenjual(String id) {
        penjualRepository.deleteById(id);  // Delete Penjual by id
    }
}
