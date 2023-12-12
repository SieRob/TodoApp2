package be.vdab.todo_applicatie2.todo;

import java.time.LocalDateTime;

public record TodoResponse(long mensId, String tekst, int prioriteit, LocalDateTime gemaakt) {
}
