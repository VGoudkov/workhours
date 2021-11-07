package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Должность
 */
@Entity
@Table( name = "wh_position")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Position extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "at_division_fk")
    private Division atDivision;

    private BigDecimal salary;
}