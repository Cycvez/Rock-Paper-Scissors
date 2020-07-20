
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlo
 */
public class HeartyHearts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age;
        System.out.println("Please enter your age: ");
        age = Integer.parseInt(sc.nextLine());

        int maxRate = 220 - age;
        double lowRange = .5 * maxRate;
        double highRange = .85 * maxRate;

        System.out.println("Your max Heart Rate should be: " + maxRate + " Rate per Min.");
        System.out.println("Your target zone Should be between " + String.format("%.1f", lowRange) + " and "
                + String.format("%.1f", highRange));

    }

}
