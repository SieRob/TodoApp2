package be.vdab.todo_applicatie2;

import be.vdab.todo_applicatie2.mens.MensResponse;
import be.vdab.todo_applicatie2.todo.TodoResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface Requests {
    @GetExchange("mensen/{id}")
    MensResponse findById(@PathVariable long id);

    @GetExchange("mensen/{id}/todos")
    TodoResponse[] findTodosById(@PathVariable long id);

}
