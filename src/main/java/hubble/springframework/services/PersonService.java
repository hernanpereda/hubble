package hubble.springframework.services;

import hubble.springframework.domain.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    List<Person> getPersonList();

    int getAverageAge();

    void deleteData();
}
