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
        int contadorOperadores = 0;
        for(Character c: formula.toCharArray()){
            if(Character.isDigit(c)){
                continue;
            } else if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')){
                contadorOperadores++;
            } else{
                fail("La fórmula está mal estructurada.");
            }
        }
        assertTrue(contadorOperadores>=2 && contadorOperadores<=3);
    } // Las fórmulas esperadas deben tener entre 2 (mínimo) y 3 (máximo) operadores.
    
    void TCMF03() {
        String formula = Operations.MakeFormula();
        int contadorNum = 0;
        char[] formulaArray = formula.toCharArray();
        for(int i = 0; i<formula.length();i++){
            if(Character.isDigit(formulaArray[i]) && !Character.isDigit(formulaArray[i+1])){
                contadorNum++;
            } else if(formulaArray[i]=='+' || formulaArray[i]=='-' || formulaArray[i]=='*' || formulaArray[i]=='/'){
                continue;
            } else{
                fail("La fórmula está mal estructurada.");
            }
        }
        assertTrue(contadorNum>=3 && contadorNum<=4);
    } // Las fórmulas esperadas deben tener entre 3 (mínimo) y 4 (máximo) operandos.
    
    void TCMF04() {
        String formula = Operations.MakeFormula();        
        assertTrue(formula.length()>=5 && formula.length()<=11);
    } // Las fórmulas esperadas deben tener entre 5 (mínimo) y 5 (máximo) de longitud.

    /**
     * Test of Solve method, of class Operations.
     */    

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
