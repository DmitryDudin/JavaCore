package ua.com.javatraining.genericswildcards;

import ua.com.javatraining.genericswildcards.entity.Car;
import ua.com.javatraining.genericswildcards.entity.Machine;
import ua.com.javatraining.genericswildcards.entity.Tavriya;
import ua.com.javatraining.genericswildcards.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcard {

    public static void main(String[] args) {
        LowerBoundedWildcard executor = new LowerBoundedWildcard();

        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
//        executor.soundAllLowerBoundedWildcard(objectList);//ClassCastException

        List<Machine> machineList = new ArrayList<>();
        machineList.add(new Machine());
        executor.soundAllLowerBoundedWildcard(machineList);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle());
        executor.soundAllLowerBoundedWildcard(vehicleList);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        executor.soundAllLowerBoundedWildcard(carList);

        List<Tavriya> tavriyaList = new ArrayList<>();
        tavriyaList.add(new Tavriya());
//        executor.soundAllLowerBoundedWildcard(tavriyaList);//non compliant
    }

    private void soundAllLowerBoundedWildcard(List<? super Car> cars) {
        cars.add(new Tavriya());//possible add object of subclass

        System.out.println("---execute soundAllCarsLowerBoundedWildcard!!! --->  " + cars.get(0).getClass());
        cars
//                .forEach(Car::sound)//Non-static method cannot be referenced from a static context (?????????????????????????)
                .forEach(car -> car.toString())//there no Cars methods, only Objects (?????????????????????????)
        ;

        cars
                .stream()
                // т.е. при lower bound тип параметра приводится(стерается) к Object(!!!!!!!!!!!!!!!!!!!!)
                .map(car -> (Machine) car)//только так !!! ???
//                .map(car -> (Tavriya) car)//ClassCastException
//                .map(car -> (Car) car)//ClassCastException
//                .map(car -> (Vehicle) car)//ClassCastException
                .forEach(Machine::sound);
    }


}
