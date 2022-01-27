package ru.vgoudk.workhours.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.vgoudk.workhours.model.finance.Division;
import ru.vgoudk.workhours.model.finance.Position;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PositionRepositoryTest {

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    DivisionRepository divisionRepository;

    @Test
    public void shouldCreateDivisionWhenSavingPosition() throws Exception {
        var divison = Division.builder()
                .description("Division #1")
                .build();

        var position = Position.builder()
                .atDivision(divison)
                .description("Position #11")
                .build();

        positionRepository.save(position);
        assertThat(position.getId()).isNotNull();
    }

    @Test
    @Sql("/create-position.sql")
    public void shouldLoadDivision() throws Exception {
        var loadedDivison = divisionRepository.findAll().get(0);
        assertThat(loadedDivison.getUsedInPositions()).isNotEmpty();
    }
}