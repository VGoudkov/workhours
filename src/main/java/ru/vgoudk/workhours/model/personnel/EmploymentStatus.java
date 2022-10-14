package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>Статус сотрудника во время работы</p>
 * Возможные варианты
 * <ul>
 *     <li>в декрете</li>
 *     <li>болен</li>
 *     <li>уволен</li>
 * </ul>
 */
@Entity
@Table(name = "wh_employment_status")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EmploymentStatus extends AbstractEntity {
    private static final long serialVersionUID = 1L;
}
