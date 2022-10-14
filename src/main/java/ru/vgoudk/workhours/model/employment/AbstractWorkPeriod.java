package ru.vgoudk.workhours.model.employment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Период работы (по основному месту или для получения надбавки
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractWorkPeriod extends AbstractEntity {
    /**
     * Дата начала работы (первый день)
     */
    @NonNull
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    /**
     * Дата окончания работы (включая)
     */
    @Nullable
    @Column(name = "to_date", nullable = true)
    private LocalDate toDate;
}
