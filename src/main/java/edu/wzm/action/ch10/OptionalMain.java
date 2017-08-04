package edu.wzm.action.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gatsbynewton on 2017/7/31.
 */
public class OptionalMain {

    public static void main(String[] args) {
        OptionalMain main = new OptionalMain();
        Person person = new Person(new Car(new Insurance("insurance_1")));

        /* has a person */
        System.out.println(main.getCarInsuranceName(Optional.ofNullable(person)));

        /* has null */
        System.out.println(main.getCarInsuranceName(Optional.ofNullable(null)));

        /* Optional.empty() */
        System.out.println(main.getCarInsuranceName(Optional.empty()));

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        System.out.println(main.getCarInsuranceNames(persons));
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        Stream<Optional<String>> stream = persons.stream()
            .map(Person::getCar)
            .map(optCar -> optCar.flatMap(Car::getInsurance))
            .map(optInsurance -> optInsurance.map(Insurance::getName));

        return stream.map(x -> x.orElse("Unknown"))
            .collect(Collectors.toSet());
    }
}
