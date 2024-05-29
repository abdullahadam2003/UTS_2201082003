package com.abdullah.pembayaran.controller;

import com.abdullah.pembayaran.Entity.Pembayaran;
import com.abdullah.pembayaran.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @GetMapping
    public ResponseEntity<List<Pembayaran>> getAllPembayaran() {
        List<Pembayaran> pembayaranList = pembayaranService.getAllPembayaran();
        return new ResponseEntity<>(pembayaranList, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Pembayaran> getPembayaranById(@PathVariable("id") Long id) {
        Pembayaran pembayaran = pembayaranService.getPembayaranById(id);
        if (pembayaran != null) {
            return new ResponseEntity<>(pembayaran, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> insertPembayaran(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insertPembayaran(pembayaran);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletePembayaran(@PathVariable("id") Long id) {
        boolean deleted = pembayaranService.deletePembayaran(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
