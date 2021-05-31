package com.devx.math;

/**
 * @author I348618
 * @since 5/31/2021
 */
public class Reverse32BitInteger {
    int reverse(int n) {
        boolean isNegative = n<0;
        if(isNegative)
            n*=-1;
        int sum=0, prev=0;
        while(n>0) {
            sum = sum*10 + n%10;
            if((sum-n%10)/10 != prev)
                return 0;
            prev = sum;
            n/=10;
        }
        if(isNegative)
            sum*=-1;
        System.out.print("Reverse: "+sum+", Condition: ");
        return sum;
    }

    public static void main(String[] args) {
        Reverse32BitInteger r = new Reverse32BitInteger();
        System.out.println(r.reverse(-2020) == -202);
        System.out.println(r.reverse(0) == 0);
        System.out.println(r.reverse(-1000) == -1);
        System.out.println(r.reverse(Integer.MIN_VALUE) == 0);
        System.out.println(r.reverse(123456789));
    }
}
