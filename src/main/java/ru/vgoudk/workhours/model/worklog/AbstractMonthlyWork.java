package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.personnel.FillingResponsible;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Месячная отработка, бывает разных типов
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractMonthlyWork extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * Отработано в расчётном периоде
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "salary_period_fk")
    private SalaryPeriod salaryPeriod;

    /**
     * Кем заполнено
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "filling_responsible_fk")
    private FillingResponsible fillingResponsible;

    /**
     * Заполнено с IP адреса
     */
    @NonNull
    @Column(name = "operation_ip", length = 60, nullable = false)
    private String operationIp;

    /**
     * Дата заполнения
     */
    @NonNull
    @Column(name = "operation_date_time", nullable = false)
    private LocalDateTime operation_date_time;
}
