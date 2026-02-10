package com.visualizer;

import java.util.List;

import io.javalin.Javalin;
import io.javalin.json.JavalinGson;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.jsonMapper(new JavalinGson());
            config.staticFiles.add("/public");
        });

        app.get("/api/sort", ctx -> {
            String algo = ctx.queryParam("algorithm");
            String arrayParam = ctx.queryParam("array");

            String[] paramArr = arrayParam.split(",");
            int[] arr = new int[paramArr.length];
            for (int i = 0; i < paramArr.length; i++) {
                arr[i] = Integer.parseInt(paramArr[i]);
            }

            List<SortStep> steps;
            if ("Quick".equalsIgnoreCase(algo)) {
                steps = QuickSort.sort(arr);
            } else if ("Merge".equalsIgnoreCase(algo)) {
                steps = MergeSort.sort(arr);
            } else {
                steps = BubbleSort.sort((arr));
            }
            ctx.json(steps);
        });
        
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "7071"));
        app.start(port);
        System.out.println("Server started on http://localhost:7070");
    }
}
