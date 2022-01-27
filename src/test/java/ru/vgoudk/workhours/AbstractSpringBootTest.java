package ru.vgoudk.workhours;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Общий предок для всех классов тестов
 */
@SpringBootTest
@ActiveProfiles("test")
public abstract class AbstractSpringBootTest {
}