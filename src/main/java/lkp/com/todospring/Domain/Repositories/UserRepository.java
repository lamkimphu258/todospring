package lkp.com.todospring.Domain.Repositories;

import lkp.com.todospring.Domain.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
