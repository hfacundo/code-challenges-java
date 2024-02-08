package com.tutorials;

public class BitwiseOperator {


    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseAND(int a, int b) {
        // Operador AND a nivel de bits (&)
        int resultAnd = a & b;
        System.out.println("AND a & b: " + resultAnd);  // Resultado en decimal: 1
    }

    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseOR(int a, int b) {
        // Operador OR a nivel de bits (|)
        int resultOr = a | b;
        System.out.println("OR a | b: " + resultOr);  // Resultado en decimal: 7
    }

    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseXOR(int a, int b) {
        // Operador XOR a nivel de bits (^)
        int resultXor = a ^ b;
        System.out.println("XOR a ^ b: " + resultXor);  // Resultado en decimal: 6
    }

    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseLeftShift(int a, int b) {
        // Desplazamiento a la izquierda a nivel de bits (<<)
        int resultLeftShift = a << 2;
        System.out.println("Desplazamiento a la izquierda a << 2: " + resultLeftShift);  // Resultado en decimal: 20
    }

    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseRightShift(int a, int b) {
        // Desplazamiento a la derecha con signo a nivel de bits (>>)
        int resultRightShiftSigned = a >> 1;
        System.out.println("Desplazamiento a la derecha con signo a >> 1: " + resultRightShiftSigned);  // Resultado en decimal: 2
    }

    /**
     * int a = 5;  // Representado en binario: 0101
     * int b = 3;  // Representado en binario: 0011
     * @param a
     * @param b
     */
    public static void bitwiseRightShiftUnsigned(int a, int b) {
        // Desplazamiento a la derecha sin signo a nivel de bits (>>>)
        int resultRightShiftUnsigned = a >>> 1;
        System.out.println("Desplazamiento a la derecha sin signo a >>> 1: " + resultRightShiftUnsigned);  // Resultado en decimal: 2
    }

    public static void main(String[] args) {
        int a = 5;  // Representado en binario: 0101
        int b = 3;  // Representado en binario: 0011
        bitwiseAND(a, b);
        bitwiseOR(a, b);
        bitwiseXOR(a, b);
        bitwiseLeftShift(a, b);
        bitwiseRightShift(a, b);
        bitwiseRightShiftUnsigned(a, b);
    }
}
