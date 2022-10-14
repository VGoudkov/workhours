package ru.vgoudk.workhours.model.personnel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
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
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FillingGroupId id;

    /**
     * Ответственный за заполнение
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "filling_responsible_fk")
    @MapsId(value = "fillingResponsible")
    private FillingResponsible fillingResponsible;

    /**
     * Сотрудник, для которого нужно заполнять
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "employee_fk")
    @MapsId(value = "employee")
    private Employee employee;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FillingGroupId implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Ответственный за заполнение
         */
        @Column(name = "filling_responsible_fk")
        private Integer fillingResponsible;

        /**
         * Сотрудник, для которого нужно заполнять
         */
        @Column(name = "employee_fk")
        private Integer employee;
    }
}
