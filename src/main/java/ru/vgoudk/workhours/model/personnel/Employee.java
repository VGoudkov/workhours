package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Сотрудник
 */
@Entity
@Table(name = "wh_employee")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employee extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Фамилия
     */
    private String lastName;
    /**
     * Имя
     */
    private String firstName;
    /**
     * Отчество
     */
    private String patronymic;
}