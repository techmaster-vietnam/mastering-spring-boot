package vn.techmaster.hazelcast.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.hazelcast.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
