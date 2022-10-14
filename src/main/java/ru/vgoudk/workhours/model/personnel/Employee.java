package ru.vgoudk.workhours.model.personnel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.AbstractEntity;
import ru.vgoudk.workhours.model.RoleLink;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Сотрудник
 */
@Entity
@Table(name = "wh_employee")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Employee extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Фамилия
     */
    @Column(name = "family_name")
    private String familyName;

    /**
     * Имя
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Отчество
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Если этот сотрудник может заполнять данные по отработанным часам для других сотрудников
     * (см. {@link FillingGroup)}
     */
    @Nullable
    @RoleLink
    @OneToOne(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = true)
    private FillingResponsible fillingResponsible;

    @JsonIgnore
    public String getFio() {
        return familyName + " " + getFirsLetter(firstName) + getFirsLetter(patronymic);
    }

    @NonNull
    private String getFirsLetter(@Nullable String value) {
        if (value == null) return "";
        return value.substring(0, 1).toUpperCase() + ".";
    }
}
