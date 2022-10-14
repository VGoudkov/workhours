package ru.vgoudk.workhours.model.compute;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.worklog.SalaryPeriod;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @OneToMany(mappedBy = "salaryComputation", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    @Builder.Default
    private List<SalaryComputationRow> salaryComputationRows = new ArrayList<>();

    /**
     * Период, для которого проводится данный расчёт
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "salary_period_fk")
    private SalaryPeriod salaryPeriod;

    /**
     * Дата проведения расчёта
     */
    @NonNull
    @Column(name = "computation_date", nullable = false)
    private LocalDate computationDate;
}
