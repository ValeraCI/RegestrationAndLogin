package com.company;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String email;
    private String password;

    public User(String email){
        Input in = new Input();
        System.out.print("Придумайте пароль: ");
        password = in.strIn();
        this.email = email;
        System.out.print("Введите ваше имя: ");
        name = in.strIn();
        System.out.print("Введите ваш возраст: ");
        do{
            age = in.intIn();
            if(age < 4 || age > 105) System.out.println("Не врите, укажите настоящий возраст");
        }while (age < 4 || age > 105);
    }


    public boolean truePassword(String password){
        return this.password == password;
    }

    @Override
    public String toString(){
        return name + " " + age + " " + email + " " + password;
    }
}
