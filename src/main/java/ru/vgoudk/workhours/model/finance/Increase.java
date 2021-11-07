
package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Надбавка к зарплате
 */
@Entity
@Table( name = "wh_increase")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Increase extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "from_funds_id")
    private Funds fromFunds;

    @ManyToOne
    @JoinColumn(name = "for_position_id")
    private Position forPosition;

    private BigDecimal amount;
}