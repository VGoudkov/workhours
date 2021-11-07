package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ответственный за заполнение данных по человеку
 */
@Entity
@Table( name = "wh_filling_responsible")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingResponsible extends AbstractEntity {
    private String email;
    private String encryptedPassword;
}