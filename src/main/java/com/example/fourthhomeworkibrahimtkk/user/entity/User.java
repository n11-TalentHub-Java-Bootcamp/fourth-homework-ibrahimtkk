package com.example.fourthhomeworkibrahimtkk.user.entity;

import com.example.fourthhomeworkibrahimtkk.generator.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Data
@Builder
@NoArgsConstructor
public class User implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String password;
}
