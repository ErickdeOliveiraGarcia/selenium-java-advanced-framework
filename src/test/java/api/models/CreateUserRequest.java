package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Generates Getters, Setters, toString, equals, and hasCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String job;
}

