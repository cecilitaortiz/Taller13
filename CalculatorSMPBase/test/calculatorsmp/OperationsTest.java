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
    
    @DisplayName("Prueba de que la fórmula tenga la cantidad de operadores esperados")
    @Test
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
    
    @DisplayName("Prueba de que la fórmula tenga la cantidad de operandos esperados")
    @Test
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
    
    @DisplayName("Prueba de que la fórmula tenga la longitud esperada")
    @Test
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
    
    @DisplayName("Prueba para verificar el resultado si pongo letras alfábeticas sin más.")
    @Test
    void TCS05() {
        // Verifica que pasa si meto un String sin más.
        assertEquals("abcd=abcd", Operations.Solve("abcd"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo solo un operando sin un operador.")
    @Test
    void TCS06() {
        // Verifica que pasa si meto un operando sin más.
        assertEquals("0=0", Operations.Solve("0"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo solo un operador sin un operando.")
    @Test
    void TCS07() {
        // Verifica que pasa si meto un operador sin más.
        assertEquals("+=0", Operations.Solve("+"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo un String, un operador y un número.")
    @Test
    void TCS08() {
        // Verifica que pasa si pongo un String, un operador y un número.
        assertEquals("a+1=1", Operations.Solve("a+1"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo solo un operador y un número.")
    @Test
    void TCS09() {
        // Verifica que pasa si pongo solo un operador y un número.
        assertEquals("+1=1", Operations.Solve("+1"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo primero un número y luego un operando.")
    @Test
    void TCS010() {
        // Verifica que pasa si pongo primero un número y luego un operando.
        assertEquals("0+=0+", Operations.Solve("0+"));
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo una operación entre dos Strings.")
    @Test
    void TCS011() {
        // Verifica que pasa si pongo una operación entre dos Strings.
        try {
            Operations.Solve("a+a");
            fail("Se esperaba una NumberFormatException");
        } catch (NumberFormatException e) {            
            assertEquals(true, true);
        }
    }
    
    @DisplayName("Prueba para verificar el resultado si pongo tres operadores seguidos en vez de operandos.")
    @Test
    void TCS012() {
        // Verifica que pasa si pongo tres operadores seguidos en vez de operandos.
        assertEquals("+++=0", Operations.Solve("+++"));
    }

}
