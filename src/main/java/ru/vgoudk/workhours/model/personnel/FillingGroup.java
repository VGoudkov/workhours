package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Группа сотрудников, за заполнение данных которых отвечает конкретный человек
 */
@Entity
@Table(name = "wh_filling_group")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingGroup {

    @EmbeddedId
    private FillingGroupId id;

    /**
     * Ответственный за заполнение
     */
    @ManyToOne
    @JoinColumn(name = "filling_responsible_fk")
    @MapsId(value = "fillingResponsible")
    private FillingResponsible fillingResponsible;

    /**
     * Сотрудник, для которого нужно заполнять
     */
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    @MapsId(value = "forEmployee")
    private Employee forEmployee;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @SuperBuilder
    public static class FillingGroupId implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Ответственный за заполнение
         */
        private Long fillingResponsible;

        /**
         * Сотрудник, для которого нужно заполнять
         */
        private Long forEmployee;
    }
}