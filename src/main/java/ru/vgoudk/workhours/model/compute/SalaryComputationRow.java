package ru.vgoudk.workhours.model.compute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Строка ежемесячного расчёта зарплаты для конкретного сотрудника
 */
@Entity
@Table(name = "wh_salary_computation_row")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryComputationRow extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    /**
     * К какому расчёту зарплаты относится данная строка
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "salary_computation_fk")
    private SalaryComputation salaryComputation;

    /**
     * <p>Тестовое описание всех шагов расчёта в tab-delimited формате, пригодное для экспорта в Excel или Word</p>
     * Несёт две обязанности:
     * <ul>
     *     <li>1. Сохраняет лог расчёта и актуальные настройки, чтобы на них можно было посмотреть потом</li>
     *     <li>2. В случае возникновения вопросов по сумме - позволяет проверить все этапы вручную</li>
     * </ul>
     */
    @NonNull
    @Column(name = "work_log", length = 16000)
    private String workLog;

}
