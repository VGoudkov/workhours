package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.employment.AbstractWorkPeriod;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Зарплата в должности
 */
@Entity
@Table(name = "wh_position_salary")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PositionSalary extends AbstractWorkPeriod {

    /**
     * Должность в подразделении, для которой действует зарплата
     */
    @Nullable
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "position_fk")
    private Position position;

    /**
     * Месячная зарплата в этой должности
     */
    @NonNull
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
}
