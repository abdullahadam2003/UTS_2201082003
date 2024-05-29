package com.abdullah.produk.controller;

import com.abdullah.produk.entity.Produk;
import com.abdullah.produk.service.ProdukService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProdukController handles requests for managing Produk entities.
 */
@RestController
@RequestMapping("api/v1/product")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    /**
     * Retrieves a list of all produk entities.
     *
     * @return a list of Produk entities.
     */
    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }

    /**
     * Retrieves a single Produk entity by its ID.
     *
     * @param id the ID of the Produk entity to retrieve.
     * @return the Produk entity with the specified ID.
     */
    @GetMapping(path = "{id}")
    public Produk getProduct(@PathVariable("id") Long id) {
        return produkService.getProduct(id);
    }

    /**
     * Inserts a new Produk entity.
     *
     * @param produk the Produk entity to insert.
     */
    @PostMapping
    public void insert(@RequestBody Produk produk) {
        produkService.insert(produk);
    }

    /**
     * Deletes a Produk entity by its ID.
     *
     * @param id the ID of the Produk entity to delete.
     */
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        produkService.delete(id);
    }
}
