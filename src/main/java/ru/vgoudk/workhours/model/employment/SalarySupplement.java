package ru.vgoudk.workhours.model.employment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.finance.Supplement;
import ru.vgoudk.workhours.model.personnel.Employee;
import ru.vgoudk.workhours.model.worklog.MonthlySupplement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Работа с получением надбавки
 */
@Entity
@Table(name = "wh_salary_supplement")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
//TODO: Уточнить у Аллы, может ли быть два раза одна и та же надбавка одному человеку.
//  если нет - то тут должен быть @EmbeddedId
public class SalarySupplement extends AbstractWorkPeriod {
    /**
     * Кому надбавка
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "employee_fk")
    private Employee employee;

    /**
     * Какая надбавка, т.е. как её рассчитывать исходя из количества отработанных смен ({@link MonthlySupplement}
     */
    @NonNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "supplement_fk")
    private Supplement supplement;
}
