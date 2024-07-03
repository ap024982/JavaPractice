package org.example;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambda implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String name, Context context) {
        String message = "Hello " + name;
        System.out.println(message);
        return message;
    }
}
