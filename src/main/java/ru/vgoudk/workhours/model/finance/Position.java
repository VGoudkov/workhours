package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Должность
 */
@Entity
@Table(name = "wh_position")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Position extends AbstractEntity {

    /**
     * Должность в подразделении
     */
    @Nullable
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "division_fk")
    private Division division;

    @OneToMany(mappedBy = "position")
    private List<PositionSalary> positionSalaries;
}
