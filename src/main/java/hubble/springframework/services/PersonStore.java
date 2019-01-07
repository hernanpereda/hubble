package hubble.springframework.services;

import hubble.springframework.domain.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value="session",  proxyMode= ScopedProxyMode.TARGET_CLASS)
public class PersonStore implements Serializable{

    private List<Person> personList = new ArrayList<>();

    public Person addPerson(Person person) {
        personList.add(person);
        return person;
    }

    public List<Person> personList() {
        return personList;
    }

    public void cleanData() {
        personList = new ArrayList<>();
    }
}
