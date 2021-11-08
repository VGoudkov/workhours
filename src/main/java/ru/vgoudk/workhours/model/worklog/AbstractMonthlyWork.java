package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.personnel.FillingResponsible;

import javax.persistence.*;
import java.time.Month;

/**
 * Месячная отработка, бывает разных типов
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractMonthlyWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Отработано в месяце
     */
    private Month inMonth;

    /**
     * Отработано в году
     */
    private Integer inYear;

    @ManyToOne
    @JoinColumn(name = "filled_by_fk")
    private FillingResponsible filledBy;

}