package task_5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;

public class Task_5XML {

    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            File inputXML = new File("Java_AQA3/main/resources/task_5/input.xml");
            File outputXML = new File("Java_AQA3/main/resources/task_5/output.xml");

            Person person = xmlMapper.readValue(Files.readString(inputXML.getAbsoluteFile().toPath()), Person.class);

            System.out.println("Original person data: " + person);
            person.setName("Updated Name");
            person.setBirthdate(LocalDate.of(1992, 6, 15));
            person.getAddress().setCity("Updated City");

            System.out.println("Modified person data: " + person);

            xmlMapper.writeValue(outputXML, person);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
