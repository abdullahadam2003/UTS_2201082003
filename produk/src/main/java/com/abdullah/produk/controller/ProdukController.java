package com.abdullah.produk.controller;

import com.abdullah.produk.entity.Produk;
import com.abdullah.produk.service.ProdukService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/product")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

   
    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }

    
   
    @GetMapping(path = "{id}")
    public Produk getProduct(@PathVariable("id") Long id) {
        return produkService.getProduct(id);
    }

   
    @PostMapping
    public void insert(@RequestBody Produk produk) {
        produkService.insert(produk);
    }

   
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        produkService.delete(id);
    }
    @PutMapping(path = "{id}")
    public void updateProduk(@PathVariable ("id") Long id,
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) String satuan
                  
    ){
        produkService.update(id, kode, nama, satuan);
    }
}
