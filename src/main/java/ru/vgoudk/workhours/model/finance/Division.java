package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.RoleLink;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Подразделение
 */
@Entity
@Table(name = "wh_division")
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Accessors(chain = true)
public class Division extends AbstractEntity {

    /**
     * Колле
     */
    @RoleLink
    @OneToMany(mappedBy = "atDivision")
    private Collection<Position> usedInPositions;
}