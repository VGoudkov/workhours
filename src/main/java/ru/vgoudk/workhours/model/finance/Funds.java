package ru.vgoudk.workhours.model.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.RoleLink;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Средства, из которых выплачивается надбавка
 */
@Entity
@Table(name = "wh_funds")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Funds extends AbstractEntity {
    /**
     * В каких надбавках используется данный тип средств
     */
    @RoleLink
    @OneToMany(mappedBy = "fromFunds")
    private List<Supplement> usedInSupplements = new ArrayList<>();
}