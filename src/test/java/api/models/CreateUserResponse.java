package api.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data //Generates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    //Fields that match the keys in the JSON response body
    private String name;
    private String job;
    private String id;
    private String createdAt;
}