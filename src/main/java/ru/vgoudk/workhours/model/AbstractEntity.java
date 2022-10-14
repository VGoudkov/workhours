package ru.vgoudk.workhours.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * Первичный ключ записи
     */
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Описание записи в свободной форме
     */
    @Nullable
    @Column(name = "description", nullable = true)
    private String description;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + id + ", \"" + description + "\")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        return getId().equals(that.getId()) && getClass().equals(that.getClass());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
