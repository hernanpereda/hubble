package hubble.springframework.services;

import hubble.springframework.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by silver on 1/6/19.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonStore personStore;

    @Autowired
    public void setPersonStore(PersonStore personStore) {
        this.personStore = personStore;
    }

    @Override public Person savePerson(Person person) {

        return personStore.addPerson(person);
    }

    @Override public List<Person> getPersonList() {
        List<Person> personList = personStore.personList();
        if(personList.size() > 0) {
            for(Person person : personList) {

                Random random = new Random();
                int ageEnd = 60 + random.nextInt(20);

                Calendar c = Calendar.getInstance();
                c.setTime(person.getBirthDate());
                c.add(Calendar.YEAR, ageEnd);
                person.setKillDate(c.getTime());

            }

        }
        return personStore.personList();
    }

    @Override public int getAverageAge() {
        List<Person> personList = personStore.personList();
        if(personList.size() > 0) {
            int personListSize = personList.size();
            int aux = 0;
            for(Person person : personList) {
                aux += person.getAge();
            }
            return (int) (aux / personListSize);
        } else {
            return 0;
        }
    }

    @Override public void deleteData() {
        personStore.cleanData();
    }

    public static void main(String[] args) {

       // System.out.println(x);
    }
}
