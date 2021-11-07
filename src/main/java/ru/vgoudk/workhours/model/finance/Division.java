package ru.vgoudk.workhours.model.finance;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Подразделение
 */
@Entity
@Table( name = "wh_division")
@NoArgsConstructor
@SuperBuilder
public class Division extends AbstractEntity {
}