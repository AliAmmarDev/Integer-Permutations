package com.and.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class Solution {

    /**
     * This method extracts the digits from a string.
     * @param input original string.
     * @return digits string containing only digits.
     */
    public static String extractDigits(String input){

        String digits = input.replaceAll("\\D+","");
        return digits;

    }

    /**
     * This method creates all distinct permutations of a given
     * input in descending order.
     * @param input string.
     * @return result string containing all distinct permutations of input.
     */
    public static String getPermutations(String input) {

        List<String> permutations = new ArrayList<>();
        permutations.add(String.valueOf(input.charAt(0)));

        for (int i = 1; i < input.length(); i++) {
            // iterate backwards to avoid ConcurrentModificationException
            for (int j = permutations.size() - 1; j >= 0 ; j--) {
                String temp = permutations.remove(j);
                for (int k = 0; k <= temp.length(); k++) {
                    String permutation = new StringBuilder()
                            .append(temp.substring(0, k))
                            .append(input.charAt(i))
                            .append(temp.substring(k))
                            .toString();
                    // only add distinct values
                    if (!permutations.contains(permutation)) {
                        permutations.add(permutation);
                    }
                }
            }
        }

        Collections.sort(permutations, Collections.reverseOrder());
        String result = String.join(",", permutations);
        return result;

    }

    /**
     * This method returns a string containing all permutations
     * of digits in a given input.
     * @param input original input.
     * @return numbers string containing all permutations of input.
     * @exception NumberFormatException If input contains no digits.
     */
    public static String solution(String input) throws NumberFormatException {

        String digits = extractDigits(input);
        if (digits.length() == 0){
            throw new NumberFormatException("No numbers found in input");
        }
        String numbers = getPermutations(digits);
        return numbers;

    }

    /**
     * This is the main method which makes use of Solution method.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter some input:");
        String input = in.nextLine();

        String solution = solution(input);
        System.out.printf("Solution:\n%s", solution);

    }

}
