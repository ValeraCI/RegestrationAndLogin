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

    public String getEmail() {
        return email;
    }

    public boolean login(){
        Input in = new Input();
        System.out.println(name + ", рады видеть вас вновь");
        for(int i = 0; i < 3; i++){
            System.out.println("Осталось " + (3-i) + " попыток\nВведите свой пароль:");
            if(truePassword(in.strIn())){
                return true;
            }
        }
        return false;
    }

    private boolean truePassword(String password){
        return this.password.equals(password);
    }

    @Override
    public String toString(){
        return name + " " + age + " " + email + " " + password;
    }
}
