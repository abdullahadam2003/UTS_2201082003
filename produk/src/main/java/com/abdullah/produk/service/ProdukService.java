package com.abdullah.produk.service;

import com.abdullah.produk.entity.Produk;
import com.abdullah.produk.repository.ProdukRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> getAll() {
        return produkRepository.findAll();
    }

    public Produk getProduct(Long id) {
        return produkRepository.findById(id).orElse(null);
    }

    public void insert(Produk produk) {
        produkRepository.save(produk);
    }

    public void delete(Long id) {
        produkRepository.deleteById(id);
    }
    @jakarta.transaction.Transactional
    public void update(Long produkId, String kode, String nama, String satuan) {
        
        Produk produk = produkRepository.findById(produkId).orElseThrow(() 
                -> new IllegalStateException("produk tidak ada"));
        if (kode != null) {
            produk.setKode(kode);
        }
        if (nama != null && nama.length() > 0 
                && !Objects.equals(produk.getNama(), nama)) {
            produk.setNama(nama);
        }
        if (satuan != null && satuan.length() > 0 
                && !Objects.equals(produk.getSatuan(), satuan)) {
            produk.setSatuan(satuan);
        }

    }
}
