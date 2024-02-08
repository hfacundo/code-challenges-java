package com.chatgpt;

/**
    Reto: Número Palíndromo

    Escribe un programa en Java que verifique si un número entero es palíndromo.
    Un número palíndromo es aquel que se lee de la misma manera de izquierda a derecha y de derecha a izquierda.

    Por ejemplo:

    El número 12321 es palíndromo porque se lee igual en ambas direcciones.
    El número 12345 no es palíndromo porque no se lee igual de derecha a izquierda.
    Tu tarea es escribir un método llamado esPalindromo que tome un número entero como argumento y
    devuelva true si el número es palíndromo y false en caso contrario.

 */
public class PalindromeChallenge {

    public static boolean isPalindrome(int num) {
        String numStr = String.valueOf(num);
        StringBuilder b = new StringBuilder();

        for (int x=numStr.length()-1; x>=0; x--) {
            b.append(numStr.charAt(x));
        }

        return numStr.equals(b.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(94034));
        System.out.println(isPalindrome(94049));
    }
}
