package ru.vgoudk.workhours.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vgoudk.workhours.model.finance.Division;

@RestController
@RequestMapping("divisions")
public class SimpleBookRestController {
    int no = 0;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Division getDivision(@PathVariable int id) {
        return Division.builder().
                description(String.format("Division #%d, call id=%d", no++, id))
                .build();
    }
}