package ua.com.javatraining.genericswildcards;

import ua.com.javatraining.genericswildcards.entity.Car;
import ua.com.javatraining.genericswildcards.entity.Machine;
import ua.com.javatraining.genericswildcards.entity.Tavriya;
import ua.com.javatraining.genericswildcards.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcard {

    public static void main(String[] args) {
        UpperBoundedWildcard executor = new UpperBoundedWildcard();

        List<Machine> machineList = new ArrayList<>();
        machineList.add(new Machine());
//        executor.soundAllUpperBoundedWildcard(machineList);//non compliant

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle());
        executor.soundAllUpperBoundedWildcard(vehicleList);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        executor.soundAllUpperBoundedWildcard(carList);

        List<Tavriya> tavriyaList = new ArrayList<>();
        tavriyaList.add(new Tavriya());
        executor.soundAllUpperBoundedWildcard(tavriyaList);
    }

    private void soundAllUpperBoundedWildcard(List<? extends Vehicle> vehicles) {
//        This is called an upper bounded wildcard where type Vehicle is the upper bound.

//        vehicles.add(new Machine());

        System.out.println("---execute soundAll_UpperBoundedWildcard!!! --->  " + vehicles.get(0).getClass());
        vehicles.forEach(Vehicle::sound);
    }


}
