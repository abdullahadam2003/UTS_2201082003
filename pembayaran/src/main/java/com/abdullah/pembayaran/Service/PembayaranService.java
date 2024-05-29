package com.abdullah.pembayaran.service;

import com.abdullah.pembayaran.Entity.Pembayaran;
import com.abdullah.pembayaran.Repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaranById(Long id) {
        Optional<Pembayaran> pembayaranOptional = pembayaranRepository.findById(id);
        return pembayaranOptional.orElse(null);
    }

    public void insertPembayaran(Pembayaran pembayaran) {
        pembayaranRepository.save(pembayaran);
    }

    public boolean deletePembayaran(Long id) {
        if (pembayaranRepository.existsById(id)) {
            pembayaranRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
