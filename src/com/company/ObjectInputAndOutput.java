package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputAndOutput {
    private final File file;
    public ObjectInputAndOutput(String fileName){
        this.file = new File(fileName);
    }

    public void output(List users){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                oos.writeObject(users);
                System.out.println("Пользователь записан");
            }catch (IOException ioException){
                System.out.println(ioException.getMessage());
            }
        }

    public List input(){
        List users = new ArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            users = (List) ois.readObject();
        }catch (IOException ioException){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

}
