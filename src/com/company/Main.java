package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean newUser = true;
        User thisUser = null;
        ObjectInputAndOutput objectInputAndOutput = new ObjectInputAndOutput("Users.bin");
        List<User> users = objectInputAndOutput.input();
	    Regex regex = new Regex("\\w{3,9}@\\w{3,9}\\.\\w{2,5}\\b");
        String email;
        do {
            System.out.print("Введите email: ");
            email = new Scanner(System.in).nextLine();
        }while(!regex.canBe(email));

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                newUser = false;
                thisUser = users.get(i);
                break;
            }
        }
        if(newUser){
            thisUser = new User(email);
            System.out.println("Благодарим вас за регистрацию");
            users.add(thisUser);
            objectInputAndOutput.output(users);
        }
        else{
            if(!thisUser.login()) System.out.println("Зачем ты занимаешься фигнуй в попытках угадать чужой пароль? Иди учи уроки");
            else System.out.println("Вы в системе");
        }
    }
}
