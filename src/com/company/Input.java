package com.company;

import java.util.Scanner;

public class Input {
    Scanner scanner;

    public String strIn(){
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int intIn(){
        while (true){
                try {
                scanner = new Scanner(System.in);
                return scanner.nextInt();
                }
                catch (Exception exception){
                    System.out.println("Введите целое число");
                }
        }
    }
}
