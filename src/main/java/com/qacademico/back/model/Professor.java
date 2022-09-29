package com.qacademico.back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String cpf;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "professor_subject"
    )
    private List<Subject> subjects = new ArrayList<Subject>();
}
