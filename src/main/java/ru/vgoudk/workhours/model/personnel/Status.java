package ru.vgoudk.workhours.model.personnel;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Статус сотрудника во время работы
 * <ul>
 *     <li>в декрете</li>
 *     <li>болен</li>
 *     <li>уволен</li>
 * </ul>
 */
@Entity
@Table(name = "wh_status")
@NoArgsConstructor
@SuperBuilder
public class Status extends AbstractEntity {
}