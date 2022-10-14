package ru.vgoudk.workhours.model.finance;

/**
 * Период, за который начисляется установленная сумма надбавки.
 * В зависимости от этой настройки используется разный алгоритм расчёта
 */
public enum SupplementPeriodSize {
    /**
     * Рассчитывается количество отработанных часов
     */
    HOURS,
    /**
     * Рассчитывается количество отработанных дней
     */
    DAYS,
    /**
     * Рассчитывается количество отработанных месяцев
     */
    MONTHS
}