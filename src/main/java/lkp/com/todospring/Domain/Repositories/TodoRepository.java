package lkp.com.todospring.Domain.Repositories;

import lkp.com.todospring.Domain.Entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, String> {
}
