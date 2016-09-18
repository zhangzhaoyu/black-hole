package org.zzy.thinkinjava.io.serializable;

import java.io.*;
import java.time.Period;

/**
 * Created by zhaoyu on 16-9-12.
 */

class Person implements Serializable {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ObjectSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.data"));
        objectOutputStream.writeObject(new Person(12, "zhang"));
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.data"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }
}
