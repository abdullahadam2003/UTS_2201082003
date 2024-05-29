package com.abdullah.produk.service;

import com.abdullah.produk.entity.Produk;
import com.abdullah.produk.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
