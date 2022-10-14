package ru.vgoudk.workhours.repositories;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vgoudk.workhours.model.finance.Division;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
    List<Division> findByDescriptionContains(@NonNull String description);
}
