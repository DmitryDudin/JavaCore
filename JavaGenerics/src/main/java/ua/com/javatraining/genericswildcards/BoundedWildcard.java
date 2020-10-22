package ua.com.javatraining.genericswildcards;

import ua.com.javatraining.genericswildcards.entity.Car;
import ua.com.javatraining.genericswildcards.entity.Tavriya;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcard {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
//        carList.add(new Machine());//non compliant
//        carList.add(new Vehicle());//non compliant
        carList.add(new Car());
        carList.add(new Tavriya());

//todo
//        List<? extends Object> carListUpperBounded = new ArrayList<>();
        List<? extends Car> carListUpperBounded = new ArrayList<>();
        //todo capture
        carListUpperBounded.add(null);//(!!!!!!!!!!!!!!!!!!!)
//        carListUpperBounded.add(new Object());//non compliant
//        carListUpperBounded.add(new Machine());//non compliant
//        carListUpperBounded.add(new Vehicle());//non compliant
//        carListUpperBounded.add(new Car());//non compliant
//        carListUpperBounded.add(new Tavriya());//non compliant

        List<? super Car> carListLowerBounded = new ArrayList<>();
//        carListLowerBounded.add(new Machine());//non compliant
//        carListLowerBounded.add(new Vehicle());//non compliant
        carListLowerBounded.add(new Car());
        carListLowerBounded.add(new Tavriya());

    }

}
