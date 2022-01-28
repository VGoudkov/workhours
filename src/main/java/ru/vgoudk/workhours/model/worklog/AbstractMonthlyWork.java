package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.finance.SalaryPeriod;
import ru.vgoudk.workhours.model.personnel.FillingResponsible;

import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "in_period_fk")
    private SalaryPeriod inPeriod;

    /**
     * Кем заполнено
     */
    @NonNull
    @ManyToOne
    @JoinColumn(name = "filled_by_fk")
    private FillingResponsible filledBy;

    /**
     * Заполнено с IP адреса
     */
    @NonNull
    @Column(name = "filled_from_ip", length = 60)
    private String filledFromIp;

    /**
     * Дата заполнения
     */
    @NonNull
    @Column(name = "filled_at")
    private LocalDateTime filledAt;

}