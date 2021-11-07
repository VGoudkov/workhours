package ru.vgoudk.workhours.model.finance;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Средства, из которых выплачивается надбавка
 */
@Entity
@Table(name = "wh_funds")
@NoArgsConstructor
@SuperBuilder
public class Funds extends AbstractEntity {
}