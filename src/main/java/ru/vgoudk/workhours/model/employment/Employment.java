package ru.vgoudk.workhours.model.employment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.finance.Position;
import ru.vgoudk.workhours.model.personnel.Employee;
import ru.vgoudk.workhours.model.personnel.Status;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Сотрудник
 */
@Entity
@Table(name = "wh_employment")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employment extends AbstractEmploymentPeriod {
    @ManyToOne
    @JoinColumn(name = "at_position_fk")
    private Position atPosition;
    @ManyToOne
    @JoinColumn(name = "in_status_fk")
    private Status inStatus;
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;
    BigDecimal workAtPercent;
}