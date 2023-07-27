package org.example.db;

import org.example.Animals.AbstractAnimal;

import java.util.HashMap;
import java.util.Map;

import static jdk.internal.vm.StackChunk.init;

public class Db {

    public static Map<Integer, AbstractAnimal> db = new HashMap<>();

    public static void showAllAnimals() {
        for (int i = 0; i < db.size(); i++) {
            System.out.println(db.get(i+1).toString());
        }
    }
}

