package com.chatgpt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumberChallenge {

    /**
     * Reto: Encontrar el número que falta
     *
     * Escribe un programa en Java que encuentre el número que falta en una secuencia ordenada de números enteros.
     * Se te proporcionará un arreglo de enteros que representa la secuencia ordenada, pero uno de los números estará ausente.
     * Tu tarea es encontrar ese número ausente.
     *
     * Por ejemplo, si se te proporciona el arreglo [1, 2, 3, 5, 6, 7], el número ausente es 4.
     *
     * Tu objetivo es escribir un método llamado encontrarNumeroFaltante que tome como argumento un arreglo de enteros y devuelva el número que falta.
     */
    public static int findMissingNumber(int[] arr) {
        int last = arr[0];
        for (int x=0; x<arr.length; x++) {
            if (x==0) { // 0 is first element and we can skip it
                continue;
            }
            if (arr[x] == last+1) {
                last = arr[x];
            } else {
                return last+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7};
        System.out.println(findMissingNumber(arr));
    }
}
