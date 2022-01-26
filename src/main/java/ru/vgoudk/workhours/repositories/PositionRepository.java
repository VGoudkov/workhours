package ru.vgoudk.workhours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vgoudk.workhours.model.finance.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}