package be.vdab.todo_applicatie2.todo;

import be.vdab.todo_applicatie2.mens.Mens;
import be.vdab.todo_applicatie2.mens.MensNietGevondenException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensen")
public class TodoController {
    private final TodoClient todoClient;

    public TodoController(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    @GetMapping("{id}")
    Mens findById(@PathVariable long id){
        return todoClient.findById(id).orElseThrow(MensNietGevondenException::new);
    }

    @GetMapping("{id}/todos")
    List<Todo> findTodosById(@PathVariable long id){
        findById(id);
        return todoClient.findTodosById(id);
    }
}
