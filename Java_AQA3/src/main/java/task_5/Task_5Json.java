package task_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;

public class Task_5Json {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            File inputJson = new File("Java_AQA3/src/main/resources/task_5/input.json");
            File outputJson = new File("Java_AQA3/src/main/resources/task_5/output.json");

            Person person = objectMapper.readValue(Files.readString(inputJson.toPath()), Person.class);

            System.out.println("Data: " + person);
            person.setName("Updated Name");
            person.setBirthdate(LocalDate.of(1992, 6, 15));
            person.getAddress().setCity("Updated City");

            System.out.println("Modified person data: " + person);

            objectMapper.writeValue(outputJson, person);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}