package vn.techmaster.jpa.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.jpa.entity.Person;

import java.util.Collection;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findFirstByName(String name);

    List<Person> findByNameIn(Collection<String> names);
}
