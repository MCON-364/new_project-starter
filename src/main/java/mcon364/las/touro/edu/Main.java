package mcon364.las.touro.edu;

import java.util.Optional;

//placeholder
public class Main {
    public static Optional<String> getUserName(String envVarName) {
        return Optional.of(System.getenv(envVarName));
    }

    public static String getGreeting(String envVarName){
        Optional<String> userName = getUserName(envVarName);
        StringBuilder greeting = new StringBuilder();
        greeting.append("Hello, ");
        greeting.append(
            switch (userName.isPresent()) {
                case true -> yield userName.get();
                default -> yield "stranger";
            }
        );
        return greeting.toString();
    }
}