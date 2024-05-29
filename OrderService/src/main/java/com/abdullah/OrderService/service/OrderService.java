/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdullah.OrderService.service;

import com.abdullah.OrderService.entity.Order;
import com.abdullah.OrderService.repository.OrderRepository;
import com.abdullah.OrderService.vo.Produk;
import com.abdullah.OrderService.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author abdullah
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    
    public void insert(Order order){
        orderRepository.save(order);
    }
    
    @Transactional
    public void update(Long orderId, Integer jumlah, String tanggal, String status) {
        // TODO Auto-generated method stub
        Order order = orderRepository.findById(orderId).orElseThrow(() 
                -> new IllegalStateException("Order tidak ada"));
        if (jumlah != null) {
            order.setJumlah(jumlah);
        }
        if (tanggal != null && tanggal.length() > 0 
                && !Objects.equals(order.getTanggal(), tanggal)) {
            order.setTanggal(tanggal);
        }
        if (status != null && status.length() > 0 
                && !Objects.equals(order.getStatus(), status)) {
            order.setStatus(status);
        }

    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }
    
    public List<ResponseTemplate> getOrderWithProdukById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Order order = getOrderById(id);
        Produk produk = restTemplate.getForObject("http://localhost:9001/api/v1/produk/" 
                + order.getProdukId(), Produk.class);       
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);    
        vo.setProduk(produk);
        responseList.add(vo);
        return responseList;
    }
    
   
   
}
