package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Ответственный за заполнение данных по человеку
 */
@Entity
@Table(name = "wh_filling_responsible")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FillingResponsible extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Почта, которая используется как login в систему
     */
    private String email;
    /**
     * Пароль, который высылается в открытом виде на почту, но тут шифруется
     */
    private String encryptedPassword;
}