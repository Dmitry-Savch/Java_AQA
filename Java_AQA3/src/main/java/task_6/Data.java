package task_6;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Data {
//    <data>
//  <name>Katie</name>
//  <birthdate>1990-05-12</birthdate>
//    <address>
//    <street>123 Main St</street>
//    <city>Denver</city>
//    <state>CO</state>
//    </address>
//    </data>
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;


private String name;
private String birthdate;
private String address;
private String street;
private String city;
private String state;

}
