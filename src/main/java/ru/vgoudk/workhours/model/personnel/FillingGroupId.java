package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingGroupId implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Ответственный за заполнение
     */
    @ManyToOne
    @JoinColumn(name = "filling_responsible_fk")
    private FillingResponsible fillingResponsible;

    /**
     * Сотрудник, для которого нужно заполнять
     */
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;
}