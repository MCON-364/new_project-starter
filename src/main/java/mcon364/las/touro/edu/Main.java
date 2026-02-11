package mcon364.las.touro.edu;

import java.util.List;
import java.util.Optional;

public class Main {
    public static Optional<String> getUserName(String envVarName) {
        if (System.getenv(envVarName) == null) return Optional.empty();
        return Optional.of(System.getenv(envVarName));
    }

    public static String getGreeting(String envVarName) {
        Optional<String> username = getUserName(envVarName);
        StringBuilder greeting = new StringBuilder();
        greeting.append("Hello, ");
        greeting.append(username.orElse("Stranger"));
        return greeting.toString();
    }

    public static int processValues(List<List<Integer>> data) {
        int rowsProcessed = 0;
        outerLoop:
        for (List<Integer> row : data) {
            for (int num : row) {
                if (num == 0) continue outerLoop;
                if (num == 99) break outerLoop;
            }
            rowsProcessed++;
        }
        return rowsProcessed;
    }

    public static void main(String[] args) {
        System.out.println(getGreeting("USERNAME"));
        System.out.println(getGreeting("NO_SUCH_VAR"));
        System.out.println("Rows processed: " +
                processValues(List.of(
                List.of(5, 10, 15),     // Processes completely
                List.of(20, 0, 25),     // Finds 0, skips to next list
                List.of(30, 35, 40),    // Processes completely
                List.of(45, 99, 50),    // Finds 99, terminates everything
                List.of(55, 60, 65)     // Never reached
        )));
    }

}