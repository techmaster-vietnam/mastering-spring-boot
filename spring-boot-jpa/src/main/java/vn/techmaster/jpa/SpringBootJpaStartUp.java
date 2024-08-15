package vn.techmaster.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import vn.techmaster.jpa.entity.Person;
import vn.techmaster.jpa.repo.PersonRepository;

import java.util.Optional;

@EnableCaching
@SpringBootApplication
public class SpringBootJpaStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootJpaStartUp.class);
        PersonRepository personRepository = applicationContext
            .getBean(PersonRepository.class);
        Person person = new Person();
        person.setName("Techmaster");
        person = personRepository.save(person);
        System.out.println("save person: " + person);
        Optional<Person> fetchedPersonById = personRepository.findById(
            person.getId()
        );
        System.out.println("fetchedPersonById: " + fetchedPersonById);
    }
}
