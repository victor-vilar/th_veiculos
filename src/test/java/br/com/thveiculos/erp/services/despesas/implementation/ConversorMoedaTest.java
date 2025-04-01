/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.thveiculos.erp.services.despesas.implementation;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author victor
 */
public class ConversorMoedaTest {

    /**
     * Test of paraBigDecimal method, of class ConversorMoeda.
     */
    @Test
    @DisplayName("Deve transformar a String passada para um bigDecimal")
    public void testParaBigDecimal() throws Exception {

        String m1 = "R$1.000,00";
        String m2 = "R$ 2.458,88";
        String m3 = "R$ 207.458,88";

        BigDecimal b1 = ConversorMoeda.paraBigDecimal(m1);
        BigDecimal b2 = ConversorMoeda.paraBigDecimal(m2);
        BigDecimal b3 = ConversorMoeda.paraBigDecimal(m3);

        assertEquals(new BigDecimal("1000.00"), b1);
        assertEquals(new BigDecimal("2458.88"), b2);
        assertEquals(new BigDecimal("207458.88"), b3);

    }

    /**
     * Test of paraString method, of class ConversorMoeda.
     */
    @Test
    @DisplayName("Deve transforma um bigDecimal para o formato moeda br 'R$'")
    public void testParaString() throws Exception {

        BigDecimal b1 = new BigDecimal("1000");
        BigDecimal b2 = new BigDecimal("2458.88");
        BigDecimal b3 = new BigDecimal("123457.66");

        String s1 = ConversorMoeda.paraString(b1);
        String s2 = ConversorMoeda.paraString(b2);
        String s3 = ConversorMoeda.paraString(b3);

        System.out.println("R$ 1.000,00");
        System.out.println(s1);
        assertEquals("R$ 1.000,00",s1);

    }

}
