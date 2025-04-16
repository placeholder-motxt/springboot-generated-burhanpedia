package com.example.burhanpedia.service;

import com.example.burhanpedia.model.Pembeli;
import com.example.burhanpedia.repository.PembeliRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PembeliService {

    private final PembeliRepository pembeliRepository;

    // Create Pembeli
    public Pembeli createPembeli(Pembeli pembeli) {
        return pembeliRepository.save(pembeli);
    }

    // Get Pembeli by id
    public Pembeli getPembeli(String id) {
        return pembeliRepository.findById(id).orElse(null);  // Return null if not found
    }

    // Update Pembeli by id
    public Pembeli updatePembeli(Pembeli pembeli, String id) {
        Pembeli existingPembeli = pembeliRepository.findById(id).orElse(null);

        if (existingPembeli != null) {
            existingPembeli.setUsername(pembeli.getUsername());
            existingPembeli.setBalance(pembeli.getBalance());
            return pembeliRepository.save(existingPembeli);  // Save the updated Pembeli
        } else {
            throw new RuntimeException("Pembeli not found for id: " + id);
        }
    }

    // Delete Pembeli by id
    public void deletePembeli(String id) {
        pembeliRepository.deleteById(id);  // Delete Pembeli by id
    }
}
