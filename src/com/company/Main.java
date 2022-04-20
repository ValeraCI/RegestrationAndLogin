package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ObjectInputAndOutput objectInputAndOutput = new ObjectInputAndOutput("Users.bin");
        System.out.println(objectInputAndOutput.input());
	    Regex regex = new Regex("\\w{3,9}@\\w{3,9}\\.\\w{2,5}\\b");
        String email;
        do {
            System.out.print("Введите email: ");
            email = new Scanner(System.in).nextLine();
        }while(!regex.canBe(email));
        User user = new User(email);
        objectInputAndOutput.output(user);
        System.out.println(objectInputAndOutput.input());

    }
}
