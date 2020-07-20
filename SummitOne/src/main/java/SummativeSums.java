/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class SummativeSums {

    public static void main(String[] args) {
        int[] sum1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] sum2 = {999, -60, -77, 14, 160, 301};
        int[] sum3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200,-99};
        
        System.out.println("#1 Array Sum: " + arraySum(sum1));
        System.out.println("#2 Array Sum: "+ arraySum(sum2));
        System.out.println("#3 Array Sum: "+ arraySum(sum3));

    }

    public static int arraySum(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        return result;
    }
}
