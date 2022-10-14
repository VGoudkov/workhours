package ru.vgoudk.workhours.model.personnel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import ru.vgoudk.workhours.model.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
     * Если ответственный за заполнение является сотрудником
     */
    @Nullable
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = true)
    private Employee employee;

    /**
     * Почта, которая используется как login в систему, туда же засылается пароль для восстановления
     */
    @NonNull
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Пароль, который высылается в открытом виде на почту, но тут шифруется
     */
    @NonNull
    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;
}
