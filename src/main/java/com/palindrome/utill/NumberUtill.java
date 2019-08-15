package com.palindrome.utill;

public class NumberUtill {

    public static boolean checkForPalindrome(Long number) {
        Long r;
        Long sum = 0L;
        Long temporary;
        temporary = number;
        boolean result;
        while (number > 0) {
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }
        if (temporary.equals(sum)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
