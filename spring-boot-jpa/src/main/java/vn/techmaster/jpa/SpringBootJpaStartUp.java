package vn.techmaster.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import vn.techmaster.jpa.entity.Person;
import vn.techmaster.jpa.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
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

        List<Person> fetchedPersonsByNameIn = personRepository
            .findByNameIn(Arrays.asList("Techmaster", "hello"));
        System.out.println("fetchedPersonsByNameIn: " + fetchedPersonsByNameIn);

        Person fetchedPersonByName = personRepository
            .findFirstByName("hello");
        System.out.println("fetchedPersonByName: " + fetchedPersonByName);

        Person fetchedPersonByNameNot = personRepository
            .findFirstByNameNot("hello");
        System.out.println("fetchedPersonByNameNot: " + fetchedPersonByNameNot);

        List<Person> fetchedPersonsByNameLikeJpql = personRepository
            .findByNameLikeJpql(
                "t"
            );
        System.out.println("fetchedPersonsByNameLikeJpql: " + fetchedPersonsByNameLikeJpql);

        List<Person> fetchedPersonsByNameLikeNative = personRepository
            .findByNameLikeNative(
                "t"
            );
        System.out.println("fetchedPersonsByNameLikeNative: " + fetchedPersonsByNameLikeNative);

        List<Person> fetchedPersonsPagination = personRepository
            .findByNameLikeJpqlPagination(
                "t",
                PageRequest.of(0, 10)
            );
        System.out.println("fetchedPersonsPagination: " + fetchedPersonsPagination);
    }
}
