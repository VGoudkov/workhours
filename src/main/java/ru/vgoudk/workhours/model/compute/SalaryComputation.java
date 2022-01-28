package ru.vgoudk.workhours.model.compute;

import lombok.*;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.finance.SalaryPeriod;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Ежемесячный расчёт зарплаты
 */
@Entity
@Table(name = "wh_salary_computation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryComputation extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    /**
     * Список строк расчёта зарплаты, принадлежащей к данному расчёту
     */
    @OneToMany(mappedBy = "forSalaryComputation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaryComputationRow> salaryComputationRows = new ArrayList<>();

    /**
     * Период, для которого проводится данный расчёт
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "salary_period_fk")
    private SalaryPeriod salaryPeriod;

    /**
     * Дата проведения расчёта
     */
    @Column(name = "computation_date")
    private LocalDate computationDate;
}