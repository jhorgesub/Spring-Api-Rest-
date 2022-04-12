package com.informatorio.ecommerce.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreciosServiceTest {

    private PreciosService preciosService = new PreciosService();

    @Test
    void calcular_Precio_Incrementado_Debe_Devolver_Valor_Apropiado() {
        //Dado
        Integer num = 1000;
        double incremento = 0.15;
        //Cuando
        double precioIncrementado = preciosService.calcularPrecioIncrementado(num, incremento);
        //Entonces
        assertEquals(1150.0, precioIncrementado);
    }

    @Test
    void calcular_precio_incrementado_debe_ser_positivo () {
        //Dado
        Integer num = -2500;
        double incremento = 0.15;
        //Cuando
        double precioIncrementado = preciosService.calcularPrecioIncrementado(num,incremento);
        //Entonces
        assertEquals(2875.0,precioIncrementado );
    }

    @Test
    void calcular_precio_debe_ser_positivo () {
        //Dado
        Integer num = 0;
        double incremento = 0.15;
        //Cuando
        double precioIncrementado = preciosService.calcularPrecioIncrementado(num,incremento);
        //Entonces
        assertEquals(1150.0,precioIncrementado );
    }
}