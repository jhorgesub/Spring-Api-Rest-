package com.informatorio.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public class PreciosService {

    public double calcularPrecioIncrementado(Integer precio, double incremento) {
        return precio * (1 + incremento);
    }
}
