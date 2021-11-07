package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сотрудник
*/
@Entity
@Table( name = "wh_employee")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employee extends AbstractEntity {
    private String lastName;
    private String firstName;
    private String patronymic;
}