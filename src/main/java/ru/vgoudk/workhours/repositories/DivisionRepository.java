package ru.vgoudk.workhours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vgoudk.workhours.model.finance.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}