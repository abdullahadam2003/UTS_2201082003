package com.abdullah.pembayaran.service;

import com.abdullah.pembayaran.Entity.Pembayaran;
import com.abdullah.pembayaran.Repository.PembayaranRepository;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaranById(Long id) {
        return pembayaranRepository.findById(id).orElse(null);
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

   @Transactional
    public void update(Long pembayaranId, String mode_pembayaran, int ref_number, String tgl_bayar, String status, double total) {
        Pembayaran pembayaran = pembayaranRepository.findById(pembayaranId)
                .orElseThrow(() -> new IllegalStateException("pembayaran tidak ada"));
        if (mode_pembayaran != null && !mode_pembayaran.isEmpty()) {
            pembayaran.setMode_pembayaran(mode_pembayaran);
        }
        if (ref_number > 0 && !Objects.equals(pembayaran.getRef_number(), ref_number)) {
            pembayaran.setRef_number(ref_number);
        }
        if (tgl_bayar != null && !tgl_bayar.isEmpty() && !Objects.equals(pembayaran.getTgl_bayar(), tgl_bayar)) {
            pembayaran.setTgl_bayar(tgl_bayar);
        }
        if (status != null && !status.isEmpty() && !Objects.equals(pembayaran.getStatus(), status)) {
            pembayaran.setStatus(status);
        }
        if (total > 0) {
            pembayaran.setTotal(total);
        }
    }
}
