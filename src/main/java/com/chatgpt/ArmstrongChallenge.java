package com.chatgpt;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongChallenge {
    /**
     * Reto: Números Armstrong
     *
     * Escribe un programa en Java que encuentre todos los números de Armstrong en un rango dado.
     * Un número de Armstrong es aquel que es igual a la suma de sus dígitos elevados a la potencia del número total de dígitos.
     *
     * Por ejemplo, el número 153 es un número de Armstrong, ya que: 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153.
     *
     * Tu tarea es escribir un método llamado encontrarNumerosArmstrong que tome como argumentos dos números enteros,
     * inicio y fin, que representan el rango de búsqueda. El método debe encontrar y mostrar en la consola todos los números de Armstrong
     * que se encuentren dentro de ese rango.
     */
    public static List<Integer> findArmstrongNumbers(int from, int to) {
        List<Integer> numbers = new ArrayList<>();

        for (int x=from; x<= to; x++) {
            if (isArmstrongNumber(String.valueOf(x)))
                numbers.add(x);
        }

        return numbers;
    }

    private static boolean isArmstrongNumber(String number) {
        int pow = number.length();
        int num = Integer.parseInt(number);
        int result = 0;

        for (int x=0; x<number.length(); x++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(x)));
            result+=Math.pow(digit, pow);
        }

        return result == num;
    }

    public static void main(String[] args) {
        System.out.println(findArmstrongNumbers(1, 10000));
    }
}
