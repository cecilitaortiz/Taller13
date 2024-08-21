/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorsmp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Cecy
 */
public class OperationsTest {

    public OperationsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
    @DisplayName("Prueba de que la fórmula sea correcta")
    @Test
    void TCMF01() {
        String formula = Operations.MakeFormula();
        boolean isValid = true;

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (i % 2 == 0) {
                // Posición par, debería ser un número
                if (!Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            } else {
                // Posición impar, debería ser un operador (+, -, *, /)
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    isValid = false;
                    break;
                }
            }
        }

        assertTrue(isValid, "La fórmula generada no sigue el formato esperado.");
    }
    
    void TCMF02() {
        String formula = Operations.MakeFormula();
        boolean isValid = true;

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (i % 2 == 0) {
                // Posición par, debería ser un número
                if (!Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            } else {
                // Posición impar, debería ser un operador (+, -, *, /)
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    isValid = false;
                    break;
                }
            }
        }

        assertTrue(isValid, "La fórmula generada no sigue el formato esperado.");
    }

    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    //PRUEBAS PARA SOLVE

    @DisplayName("Prueba para resolver suma")
    @Test
    void TCS01() {
        // Verifica la suma simple
        assertEquals("3+5=8", Operations.Solve("3+5"));
    }

    @DisplayName("Prueba para resolver resta")
    @Test
    void TCS02() {
        // Verifica la resta simple
        assertEquals("10-2=8", Operations.Solve("10-2"));
    }

    @DisplayName("Prueba para resolver multiplicación")
    @Test
    void TCS03() {
        // Verifica la multiplicación simple
        assertEquals("4*5=20", Operations.Solve("4*5"));
    }

    @DisplayName("Prueba para resolver división")
    @Test
    void TCS04() {
        // Verifica la división simple
        assertEquals("20/4=5", Operations.Solve("20/4"));
    }

}
