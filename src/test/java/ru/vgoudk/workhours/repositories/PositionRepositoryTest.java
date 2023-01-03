package ru.vgoudk.workhours.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import ru.vgoudk.workhours.AbstractSpringBootTest;
import ru.vgoudk.workhours.model.finance.Division;
import ru.vgoudk.workhours.model.finance.Position;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class PositionRepositoryTest extends AbstractSpringBootTest {

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    DivisionRepository divisionRepository;

    @Test
    void shouldCreateDivisionWhenSavingPosition() {
        var division = Division.builder()
                .description("Division #1")
                .build();

        var position = Position.builder()
                .division(division)
                .description("Position #11")
                .build();

        positionRepository.save(position);
        assertThat(position.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Sql("/sql/create-position.sql")
    void shouldLoadDivision() {
        var loadedDivision = divisionRepository.findById(100).orElseThrow();
        assertThat(loadedDivision.getUsedInPositions()).hasSize(2);
    }
}
