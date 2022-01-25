package ru.vgoudk.workhours.model.worklog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.personnel.FillingResponsible;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "in_month")
    private Month inMonth;

    /**
     * Отработано в году
     */
    @Column(name = "in_year")
    private Integer inYear;

    @ManyToOne
    @JoinColumn(name = "filled_by_fk")
    private FillingResponsible filledBy;

    @Column(name = "filled_from_ip", length = 60)
    private String filledFromIp;

    @Column(name = "filled_at")
    private LocalDateTime filledAt;

}