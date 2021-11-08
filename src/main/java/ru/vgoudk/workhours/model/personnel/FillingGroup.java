package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Группа сотрудников, за заполнение данных которых отвечает конкретный человек
 */
@Entity
@Table(name = "wh_filling_group")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingGroup {
    @EmbeddedId
    private FillingGroupId id;
}