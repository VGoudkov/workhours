package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * Должность
 */
@Entity
@Table(name = "wh_position")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Position extends AbstractEntity {

    /**
     * Должность в подразделении
     */
    @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "at_division_fk")
    private Division atDivision;

    /**
     * Месячная зарплата в этой должности
     */
    private BigDecimal salary;
}