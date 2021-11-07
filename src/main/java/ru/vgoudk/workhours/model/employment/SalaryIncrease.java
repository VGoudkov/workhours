package ru.vgoudk.workhours.model.employment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.personnel.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table( name = "wh_salary_increase")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class SalaryIncrease extends AbstractEmploymentPeriod {
    @ManyToOne
    @JoinColumn(name = "for_employee_fk")
    private Employee forEmployee;
}