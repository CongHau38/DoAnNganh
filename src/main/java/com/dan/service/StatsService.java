/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dan.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsService {
    List<Object[]> banhStats(String kw, Date fromDate, Date toDate);
}
