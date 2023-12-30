package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class Contact {
   // private String id;
    private String name;
    private String lastName;
    private String phone; //pattern: ^\d{10,15}$
    private String email;
    private String address;
    private String description;

}
