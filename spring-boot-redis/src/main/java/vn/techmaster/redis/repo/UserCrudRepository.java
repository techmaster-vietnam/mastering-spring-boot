package vn.techmaster.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.redis.data.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, String> {}
