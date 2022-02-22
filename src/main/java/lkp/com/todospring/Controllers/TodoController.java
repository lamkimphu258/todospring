package lkp.com.todospring.Controllers;

import lkp.com.todospring.Domain.Entities.Todo;
import lkp.com.todospring.Domain.Repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @ModelAttribute(name = "todo")
    public Todo todo() {
        return new Todo();
    }

    @ModelAttribute(name = "todos")
    public Iterable<Todo> todos() {
        return todoRepository.findAll();
    }

    @GetMapping("")
    public String todoList(Model model) {
        return "todos/list";
    }

    @GetMapping("/{id}/delete")
    public String todoDelete(@PathVariable("id") String id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @PostMapping
    public String todoCreate(
            @Valid Todo todo,
            Errors errors
    ) {
        if (errors.hasErrors()) {
            return "todos/list";
        }
        todoRepository.save(todo);
        return "redirect:/todos";
    }
}
