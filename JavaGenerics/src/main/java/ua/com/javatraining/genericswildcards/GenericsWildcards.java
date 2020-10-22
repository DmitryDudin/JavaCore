package ua.com.javatraining.genericswildcards;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

    public static void main(String[] args) {
        Number[] numberArr = new Long[3];
        numberArr[0] = 123L;
//        numberArr[0] = 123d;//ArrayStoreException

        Object[] objArr = new String[3];
        objArr[0] = "someString";
//        objArr[0] = 123L;//ArrayStoreException

//        List<Object> objList = new ArrayList<String>();//compilation error

        //---

        List<House> houseList = new ArrayList<>();
        houseList.add(new House());
//        paintAllBuildings(houseList);//no compile
        paintAllBuildingsBoundedWildcard(houseList);

        //---

        //---
        System.out.println("Finish-------------------------------------------------------");
    }

    public static void paintAllBuildings(List<Building> buildings) {
        System.out.println("---execute paintAllBuildings!!!");
    }

    public static void paintAllBuildingsBoundedWildcard(List<? extends Building> buildings) {
        System.out.println("---execute paintAllBuildingsBoundedWildcard!!!");
        buildings.forEach(Building::paint);
    }

    static class Building {
        public void paint() {
            System.out.println("--- paint Building!!!");
        }
    }

    static class House extends Building {

        public void paint() {
            System.out.println("--- paint House!!!");
        }
    }

}
