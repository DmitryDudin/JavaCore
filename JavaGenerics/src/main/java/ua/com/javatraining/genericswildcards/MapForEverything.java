package ua.com.javatraining.genericswildcards;

import ua.com.javatraining.genericswildcards.entity.Car;
import ua.com.javatraining.genericswildcards.entity.Machine;
import ua.com.javatraining.genericswildcards.entity.Tavriya;
import ua.com.javatraining.genericswildcards.entity.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapForEverything {

    public static void main(String[] args) {

//        Map<? super Object, String> mapForEverything = new HashMap<>();
//        Map<? extends Object, ? super Object> mapForEverything = new HashMap<>();
//        Map<? super Object, ? extends Object> mapForEverything = new HashMap<>();
//        Map<? super Object, ? super Object> mapForEverything = new HashMap<>();
        Map<Object, Object> mapForEverything = new HashMap<>();
//        Map<?, ?> mapForEverything = new HashMap<>();

        mapForEverything.put(String.valueOf("asf"), "String");
        mapForEverything.put(Integer.valueOf(1), "Integer");
        mapForEverything.put(Long.valueOf(3), "Long");
        mapForEverything.put(3d, "Double");
        mapForEverything.put(new KeyClazz("TestName", Type.TYPE_THREE), "KeyClazz");

        mapForEverything.entrySet().stream()
                .forEach(entry -> {
                    System.out.println();
                    System.out.println("key = " + entry.getKey());
                    System.out.println("value = " + entry.getValue());
                });

    }

    static class KeyClazz {
        private String name;
        private Type type;

        public KeyClazz(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return "KeyClazz{" + "name='" + name + '\'' + ", type=" + type + '}';
        }
    }

    enum Type {
        TYPE_ONE,
        TYPE_TWO,
        TYPE_THREE
    }

}
