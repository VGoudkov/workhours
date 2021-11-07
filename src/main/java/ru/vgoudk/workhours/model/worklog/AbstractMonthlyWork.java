package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.Month;

/**
 * Месячная отработка, бывает разных типов
 */
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractMonthlyWork extends AbstractEntity {
    /**
     * Отработано в месяце
     */
    private Month inMonth;

    /**
     * Отработано в году
     */
    private Integer inYear;


}