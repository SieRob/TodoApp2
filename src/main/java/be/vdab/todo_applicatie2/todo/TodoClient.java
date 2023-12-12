package be.vdab.todo_applicatie2.todo;

import be.vdab.todo_applicatie2.Requests;
import be.vdab.todo_applicatie2.mens.Mens;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class TodoClient {
    private final Requests requests;

    public TodoClient(Requests requests) {
        this.requests = requests;
    }

    public Optional<Mens> findById(long id){
        try{
            var mensResponse = requests.findById(id);
            var mens = new Mens(mensResponse.id());
            return Optional.of(mens);
        }catch (HttpClientErrorException.NotFound ex) {
            return Optional.empty();
        }
    }

    public List<Todo> findTodosById(long id){
        return Arrays.stream(requests.findTodosById(id))
                .sorted(Comparator.comparing(TodoResponse::prioriteit))
                .map(todoResponse -> new Todo(todoResponse.tekst(), todoResponse.prioriteit(), todoResponse.gemaakt()))
                .toList();
    }
}
