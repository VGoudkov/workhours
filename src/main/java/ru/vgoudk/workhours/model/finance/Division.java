package ru.vgoudk.workhours.model.finance;

import lombok.Builder;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
     * Коллекция должностей, в которой используется данное подразделение
     */
    @RoleLink
    @OneToMany(mappedBy = "atDivision")
    @Builder.Default
    private List<Position> usedInPositions = new ArrayList<>();
}