package ru.vgoudk.workhours.model.compute;

import lombok.*;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "for_salary_computation_fk")
    private SalaryComputation forSalaryComputation;

    /**
     * <p>Тестовое описание всех шагов расчёта в tab-delimited формате, пригодное для экспорта в Excel или Word</p>
     * Несёт две обязанности:
     * <ul>
     *     <li>1. Сохраняет лог расчёта и актуальные настройки, чтобы на них можно было посмотреть потом</li>
     *     <li>2. В случае возмникновении вопросов по сумме - позволяет проверить все этапы вручную</li>
     * </ul>
     */
    @Column(name = "work_log", length = 16000)
    private String workLog;

}