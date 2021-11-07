package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Группа сотрудников, за заполнение которых отвечает конкретный человек
 */
@Entity
@Table( name = "wh_filling_group")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingGroup extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "filling_responsible_fk")
    private FillingResponsible fillingResponsible;

    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;
}