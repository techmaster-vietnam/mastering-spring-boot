package vn.techmaster.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.login.entity.UserAccessToken;

@Repository
public interface UserAccessTokenRepository
    extends JpaRepository<UserAccessToken, String> {}
