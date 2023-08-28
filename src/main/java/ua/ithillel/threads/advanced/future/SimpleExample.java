package ua.ithillel.threads.advanced.future;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static ua.ithillel.utils.LogUtils.log;

public class SimpleExample {

    public static Future<String> calculateAsync(ExecutorService executor) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executor.submit(() -> {
            log("Running");
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    @SneakyThrows
    public static void main(String[] args) {
        var executorService = Executors.newCachedThreadPool();

        var future = calculateAsync(executorService);
        log(future.get());

        executorService.shutdown();
    }

}
