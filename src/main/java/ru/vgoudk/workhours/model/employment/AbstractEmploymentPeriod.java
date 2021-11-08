package ru.vgoudk.workhours.model.employment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Базовый интерфейс для определения периода работы
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractEmploymentPeriod extends AbstractEntity {
    /**
     * Дата начала работы (первый день)
     */
    private LocalDate fromDate;
    /**
     * Дата окончания работы (включая)
     */
    private LocalDate toDate;
}