package task_5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;

public class Task_5XML {

    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());

        try {
            File inputXML = new File("Java_AQA3/src/main/resources/task_5/input.xml");
            File outputXML = new File("Java_AQA3/src/main/resources/task_5/output.xml");

            if (!inputXML.exists()) {
                throw new RuntimeException("Input file not found: " + inputXML.getAbsolutePath());
            }

            Person person = xmlMapper.readValue(Files.readString(inputXML.toPath()), Person.class);

            System.out.println("Original person data: " + person);
            person.setName("Updated Name");
            person.setBirthdate(LocalDate.of(1992, 6, 15));
            person.getAddress().setCity("Updated City");

            System.out.println("Modified person data: " + person);

            xmlMapper.writeValue(outputXML, person);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}