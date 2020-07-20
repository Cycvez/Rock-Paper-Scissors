
import java.util.Random;
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
public class DogGenetics {

    static Scanner sc = new Scanner(System.in);
    static int percentLeft=100;

    public static void main(String[] args) {
        System.out.println("What is your dogs name?");
        String name = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.\n"
                + "\n"
                + name + "'s report is: ");
        
        
        System.out.println(breedPercent()+"% Alien");
        System.out.println(breedPercent()+"% Master Chief");
        System.out.println(breedPercent()+"% Preditor");
        System.out.println(breedPercent()+"% Walker");
        System.out.println(percentLeft + "% Hutt.... like Jabba");
        
        System.out.println("\n You have a weird looking dog, man.");
        


    }

    public static int breedPercent() {
        
        
        Random rng = new Random();

        int percentBreed = rng.nextInt(percentLeft) + 1;
        
        percentLeft = percentLeft-percentBreed;
        
        return percentBreed;
    }
}
