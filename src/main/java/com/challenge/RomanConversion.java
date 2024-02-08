package com.challenge;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RomanConversion {

    private static Map<Integer, String> map = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "VI");
        put(1, "I");
    }};

    private static Map<String, Integer> mapOfSymbols = new LinkedHashMap<>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL",40);
        put("X", 10);
        put("IX",9);
        put("V", 5);
        put("IV",4);
        put("I", 1);
    }};

    public String romanNumberConvertor(int n) {
        List<String> symbols = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C",
                "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM");
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
                200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000);

        if (values.contains(n))
            return symbols.get(values.indexOf(n));

        StringBuilder b = new StringBuilder();
        String numString = String.valueOf(n);

        for (int x=0; x<numString.length(); x++) {
            int num = getNum(numString, x);
            if (num > 0) {
                b.append(symbols.get(values.indexOf(num)));
            }
        }

        return b.toString();
    }

    public int getNum(String numString, int index) {
        StringBuilder b = new StringBuilder();
        b.append(numString.charAt(index));
        for (int x=index+1; x<numString.length(); x++) {
            b.append("0");
        }
        return Integer.parseInt(b.toString());
    }

    public int getFirstDigit(int n) {
        int num = n;
        while (num >= 10 ) {
            num = num/10;
        }

        return num;
    }

    int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

    /*
        Symbol    Value
        I          1
        V          5
        X          10
        L          50
        C          100
        D          500
        M          1,000
     */
    public String romanConversionEnhanced(int n) {

        StringBuilder b = new StringBuilder();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            while (n >= value) {
                b.append(symbol);
                n = n-value;
            }
        }
        return b.toString();
    }


    /*
        Create a function that takes a Roman numeral as its argument and returns its value as a numeric decimal integer. You don't need to validate the form of the Roman numeral.

        Modern Roman numerals are written by expressing each decimal digit of the number to be encoded separately, starting with the leftmost digit and skipping any 0s. So 1990 is rendered "MCMXC" (1000 = M, 900 = CM, 90 = XC) and 2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). The Roman numeral for 1666, "MDCLXVI", uses each letter in descending order.

        Example:

        solution('XXI'); // should return 21
        DXCIII should return 593
        MCCCXCIX should return 1399
        MCMVIII should return 1908
        MMMCMXCIX should return 3999

        Help:

        Symbol    Value
        I          1
        V          5
        X          10
        L          50
        C          100
        D          500
        M          1,000
     */
    public int romanDecoder(String romanNumber) {
        int result = 0;

        while (romanNumber.length() > 0) {
            int to = 1;
            if (romanNumber.length() >= 2) {
                // validate numbers that have 2 chars such as IV, IX, XL
                if (mapOfSymbols.containsKey(romanNumber.substring(0, 2))) {
                    to = 2;
                }
            }

            String substr = romanNumber.substring(0, to);
            int value = mapOfSymbols.get(substr);
            result+=value;
            romanNumber = romanNumber.substring(to);
        }

        return result;
    }

    public static void main(String[] args) {
        RomanConversion r = new RomanConversion();
        //System.out.println("first option");
        //long start = System.currentTimeMillis();
        //System.out.println("start: " +start);
        //System.out.println(r.solution(593)); // DXCIII
        //System.out.println(r.solution(1399)); // MCCCXCIX
        //System.out.println(r.solution(1908)); // MCMVIII
        //System.out.println(r.solution(3999)); // MMMCMXCIX
        //long end = System.currentTimeMillis();
        //System.out.println("end: " + end);
        //System.out.println("Time elapsed: " + (end - start) + " miliseconds");
//
        //System.out.println();
        //System.out.println("Enhanced");
        //start = System.currentTimeMillis();
        //System.out.println("start: " +start);
        //System.out.println(r.romanConversionEnhanced(593));
        //System.out.println(r.romanConversionEnhanced(1399));
        //System.out.println(r.romanConversionEnhanced(1908));
        //System.out.println(r.romanConversionEnhanced(3999));
        //end = System.currentTimeMillis();
        //System.out.println("Time elapsed: " + (end - start) + " miliseconds");
        //System.out.println("end: " + end);

        System.out.println();
        System.out.println("Roman decoder");
        //System.out.println(r.romanDecoder("XXI")); // 21
        //System.out.println(r.romanDecoder("DXCIII")); // 593
        //System.out.println(r.romanDecoder("MCCCXCIX")); // 1399
        System.out.println(r.romanDecoder("MCMVIII")); // 1908
        //System.out.println(r.romanDecoder("MMMCMXCIX")); // 3999

    }
}
