package ru.vgoudk.workhours.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vgoudk.workhours.model.finance.Division;
import ru.vgoudk.workhours.model.finance.Position;
import ru.vgoudk.workhours.repositories.DivisionRepository;
import ru.vgoudk.workhours.repositories.PositionRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doSQL")
public class SimpleSqlController {

    private final Random random = new Random(42);
    final PositionRepository positionRepository;
    final DivisionRepository divisionRepository;

    public SimpleSqlController(
            PositionRepository positionRepository,
            DivisionRepository divisionRepository) {
        this.positionRepository = positionRepository;
        this.divisionRepository = divisionRepository;
    }

    @GetMapping(produces = "text/plain")
    public String doSql() {

        final String divisionDescription = getDivisionDescription(random.nextInt(100));
        final List<Division> divisions = divisionRepository.findByDescriptionContains(divisionDescription);
        final Division division;
        if (divisions.isEmpty()) {
            division = Division.builder()
                    .description(divisionDescription)
                    .build();
        } else {
            division = divisions.get(0);
        }
        Position position = Position.builder()
                .description("Position " + 1000 + random.nextInt(100))
                .atDivision(division)
                .build();
        positionRepository.saveAndFlush(position);

        final List<Position> all = positionRepository.findAll();
        return all.stream()
                .map(p -> p.getId() + ":" + p.getDescription())
                .collect(Collectors.joining("\n"));
    }

    private String getDivisionDescription(int divisionId) {
        return "Division " + divisionId;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Division getDivision(@PathVariable int id) {
        return null;
    }

    @GetMapping(path = "delete/{id}", produces = "text/plain")
    public String deleteById(@PathVariable Long id) {
        positionRepository.deleteById(id);
        return "Deleted";
    }
}