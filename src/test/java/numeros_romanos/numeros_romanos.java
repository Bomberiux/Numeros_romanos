package numeros_romanos;

import java.util.Arrays;
import java.util.List;

public class numeros_romanos {

    private final static List<String> simbolosRomanos = Arrays.asList("I", "V", "X", "L", "C","D","M");

    public String convertirARomanos(Integer numeroNatural) {
        char[] numerosChart = numeroNatural.toString().toCharArray();

        int inc = 0;
        String resultado = "";
        for (int i = numerosChart.length - 1; i >= 0; i--) {
            String romano = generico(Character.getNumericValue(numerosChart[i]), 0 + inc, 1 + inc, 2 + inc);
            resultado = romano + resultado;
            inc += 2;
        }
        return resultado;
    }

    private String generico(int digito, int x, int y, int z) {
        switch (digito) {
            case 4:
                return simbolosRomanos.get(x) + simbolosRomanos.get(y);
            case 9:
                return simbolosRomanos.get(x) + simbolosRomanos.get(z);
        }

        if (digito <= 3)
            return sumar(0, digito, "", simbolosRomanos.get(x)); // Cambié inicioCuenta de 1 a 0

        if (digito <= 8)
            return sumar(5, digito, simbolosRomanos.get(y), simbolosRomanos.get(x)); // Cambié inicioCuenta de 6 a 5

        return "";
    }

    private String sumar(int inicioCuenta, int numeroNatural, String inicialNumeroRomano, String incRomano) {
        String resultado = inicialNumeroRomano;
        int cantidadSimbolos = numeroNatural - inicioCuenta; // Corregí la lógica del cálculo
        for (int i = 0; i < cantidadSimbolos; i++) {
            resultado += incRomano;
        }
        return resultado;
    }
}
