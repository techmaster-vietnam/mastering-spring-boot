package vn.techmaster.jpa.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.jpa.entity.Person;

import java.util.Collection;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // lấy bản ghi đầu tiên của trường name bằng tham số truyền vào
    Person findFirstByName(String name);

    // lấy bản ghi đầu tiên có trường name khác tham số truyền vào
    Person findFirstByNameNot(String name);

    // lấy tất cả các bản ghi có trường name nằm trong danh sách của tham số truyền vào
    List<Person> findByNameIn(Collection<String> names);

    // Truy vấn danh sách các bản ghi có trường name gần đúng với tham số truyền vào
    @Query("SELECT e FROM Person e WHERE e.name LIKE %?1%")
    List<Person> findByNameLikeJpql(String keyword);

    @Query(
        value = "SELECT * FROM persons WHERE name LIKE %?1%",
        nativeQuery = true
    )
    List<Person> findByNameLikeNative(String keyword);

    @Query("SELECT e FROM Person e WHERE e.name LIKE %?1%")
    List<Person> findByNameLikeJpqlPagination(
        String keyword,
        Pageable pageable
    );
}
