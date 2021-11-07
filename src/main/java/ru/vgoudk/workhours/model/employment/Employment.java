package ru.vgoudk.workhours.model.employment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.finance.Position;
import ru.vgoudk.workhours.model.personnel.Employee;
import ru.vgoudk.workhours.model.personnel.Status;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Нанятый сотрудник
 */
@Entity
@Table(name = "wh_employment")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employment extends AbstractEmploymentPeriod {
    /**
     * Кто работает
     */
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;
    /**
     * Работает в должности
     */
    @ManyToOne
    @JoinColumn(name = "at_position_fk")
    private Position atPosition;
    /**
     * Работает в "статусе", т.е. может работать "в декрете" например
     */
    @ManyToOne
    @JoinColumn(name = "in_status_fk")
    private Status inStatus;
    /**
     * Работает на процент ставки
     */
    private BigDecimal workAtPercent;
}