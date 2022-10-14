package ru.vgoudk.workhours.model.employment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.finance.Position;
import ru.vgoudk.workhours.model.personnel.Employee;
import ru.vgoudk.workhours.model.personnel.EmploymentStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Работа по основному месту
 */
@Entity
@Table(name = "wh_employment")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employment extends AbstractWorkPeriod {
    /**
     * Кто работает
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "employee_fk")
    private Employee employee;

    /**
     * Работает в должности
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "position_fk")
    private Position position;

    /**
     * Работает в "статусе", т.е. может работать "в декрете" например
     */
    @Nullable
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "employment_status_fk")
    private EmploymentStatus employmentStatus;

    /**
     * Работает на процент ставки
     */
    @NonNull
    @Column(name = "work_at_percent", nullable = false)
    @Builder.Default
    private BigDecimal workAtPercent = BigDecimal.valueOf(100);
}
