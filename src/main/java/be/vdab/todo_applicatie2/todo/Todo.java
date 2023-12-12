package be.vdab.todo_applicatie2.todo;

import java.time.LocalDateTime;

public record Todo(String tekst, int prioriteit, LocalDateTime gemaakt) {
}
