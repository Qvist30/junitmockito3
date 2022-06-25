package org.tom.chapter7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServerTest {
    @Test
    void shouldSaveTasks() throws InterruptedException {
        ExecutorService executorService = new SynchronousExecutorService();
        TaskService taskService = mock(TaskService.class);
        Task task = mock(Task.class);
        Collection<Task> listOfTasks = Arrays.asList(task);
        Server server = new Server(executorService, taskService);
        server.serve(listOfTasks);
        verify(taskService).handle(task);
    }
}
