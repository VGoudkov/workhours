package ru.vgoudk.workhours.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Описание записи в свободной форме
     */
    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + id + ", \"" + description + "\")";
    }
}