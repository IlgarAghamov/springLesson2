package org.example.model;

import lombok.*;

import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@EqualsAndHashCode
public class User {

    private int id;

    private String firstName;

    private String lastName;

}