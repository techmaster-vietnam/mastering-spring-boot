package vn.techmaster.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import vn.techmaster.hazelcast.entity.Person;
import vn.techmaster.hazelcast.service.PersonService;

@EnableCaching
@SpringBootApplication
public class SpringBootHazelcastStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootHazelcastStartUp.class);
        PersonService personService = applicationContext
            .getBean(PersonService.class);
        Person person = new Person();
        person.setName("Techmaster");
        person = personService.savePerson(person);
        System.out.println("save person: " + person);

        Person fetchedPerson1 = personService.getPersonById(
            person.getId()
        );
        System.out.println("fetched person1: " + fetchedPerson1);
        Person fetchedPerson2 = personService.getPersonById(
            person.getId()
        );
        System.out.println("fetched person2: " + fetchedPerson2);
    }
}
