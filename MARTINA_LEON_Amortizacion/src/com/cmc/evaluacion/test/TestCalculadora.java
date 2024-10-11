package com.cmc.evaluacion.test;

import com.cmc.evaluacion.Prestamo;
import com.cmc.evaluacion.CalcularAmortizacion;

public class TestCalculadora {
    public static void main(String[] args) {
        Prestamo prestamo = new Prestamo(5000, 12, 12);

        CalcularAmortizacion.generarTabla(prestamo);
        CalcularAmortizacion.mostrarTabla(prestamo);
    }
}
