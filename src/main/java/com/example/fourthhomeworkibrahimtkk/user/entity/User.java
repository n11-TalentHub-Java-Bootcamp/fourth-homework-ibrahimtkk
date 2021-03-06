package com.example.fourthhomeworkibrahimtkk.user.entity;

import com.example.fourthhomeworkibrahimtkk.generator.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String password;
}
