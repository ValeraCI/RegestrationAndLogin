package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputAndOutput {
    private final File file;
    public ObjectInputAndOutput(String fileName){
        this.file = new File(fileName);
    }

    public void output(Object obj){
        if(obj instanceof User){
            User user = (User) obj;
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true))){
                oos.writeObject(user);
                System.out.println("Пользователь записан");
            }catch (IOException ioException){
                System.out.println(ioException.getMessage());
            }
        }
        else
            System.out.println("Объект не является пользователем");
    }

    public List input(){
        List user = new ArrayList();
        User add;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while((add = (User) ois.readObject()) != null){
                user.add(add);
            }
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

        return user;
    }

}
