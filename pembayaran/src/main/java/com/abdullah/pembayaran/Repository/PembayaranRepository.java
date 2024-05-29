/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdullah.pembayaran.Repository;

import com.abdullah.pembayaran.Entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdullah
 */
@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
}

