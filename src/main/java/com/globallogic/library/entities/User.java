package com.globallogic.library.entities;

import com.globallogic.library.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "first name shouldn't be blank")
    private String firstName;
    @NotBlank(message = "last name shouldn't be blank")
    private String lastName;
    @NotBlank(message = "email shouldn't be blank")
    @Email
    @Column(unique = true)
    private String emailId;
    private Gender gender;
    @NotBlank(message = "contact shouldn't be blank")
    private String contact;
    @NotBlank(message = "password shouldn't be blank")
    private String password;
}
