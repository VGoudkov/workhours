package ru.vgoudk.workhours;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Общий предок для всех классов тестов
 */
@SpringBootTest
@ActiveProfiles("test")
public abstract class AbstractSpringBootTest {
    @Test
    void contextLoads() {
        assertTrue(true); //если тест не упал на загрузке контекста, то всё хорошо
    }
}
