package ru.vgoudk.workhours.model;

import lombok.NonNull;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HumanReadableNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    /**
     * Для тех идентификаторов, которые будут урезаны до 63 символов, добавлять эту цифру в конце, чтобы не было
     * пересечений
     */
    static final AtomicInteger counter = new AtomicInteger(1);
    /**
     * Полный список всех ключей, которые были созданы, чтобы избежать повторений
     */
    static final Set<String> existingKeys = new HashSet<>();

    /**
     * Максимальная длина идентификатора для PgSQL
     */
    static final int MAX_PG_KEY_LENGTH = 63;


    @Override
    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
        Identifier userProvidedIdentifier = source.getUserProvidedIdentifier();
        source.getBuildingContext().getBuildingOptions().getSchemaCharset();
        return userProvidedIdentifier != null ? userProvidedIdentifier : toIdentifier(
                generateKeyName0(
                        "FK",
                        source.getTableName(),
                        source.getReferencedTableName(),
                        source.getColumnNames()
                ),
                source.getBuildingContext()
        );
        //,  source.getBuildingContext().getBuildingOptions().getSchemaCharset() - временно не используется
    }


    @Override
    public Identifier determineUniqueKeyName(ImplicitUniqueKeyNameSource source) {
        Identifier userProvidedIdentifier = source.getUserProvidedIdentifier();
        source.getBuildingContext().getBuildingOptions().getSchemaCharset();
        return userProvidedIdentifier != null ? userProvidedIdentifier : toIdentifier(
                generateKeyName0(
                        "UK",
                        (source.getTableName()),
                        toIdentifier("", source.getBuildingContext()),
                        source.getColumnNames()
                ),
                source.getBuildingContext()
        );
        //,source.getBuildingContext().getBuildingOptions().getSchemaCharset() - пока не используется
    }

    protected String generateKeyName0(String prefix, Identifier tableName, Identifier referencedTableName, List<Identifier> columnNames) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("_");
        sb.append(trimPrefix(tableName.getText())).append("__");
        sb.append(trimPrefix(referencedTableName.getText())).append("__");
        for (Iterator<Identifier> iterator = columnNames.iterator(); iterator.hasNext(); ) {
            Identifier columnName = iterator.next();
            sb.append(columnName.getText());
            if (iterator.hasNext()) sb.append("_");
        }
        final String name = sb.toString();
        if (name.length() > MAX_PG_KEY_LENGTH) {
            String trimmedName = name.substring(0, MAX_PG_KEY_LENGTH - 2);
            if (existingKeys.contains(trimmedName)) {
                return trimmedName + counter.incrementAndGet();
            } else {
                existingKeys.add(trimmedName);
                return trimmedName;
            }
        } else return name;
    }

    protected String trimPrefix(@NonNull String name) {
        final String PREFIX = "WH_";
        if (name.toUpperCase().startsWith(PREFIX)) {
            return name.substring(PREFIX.length());
        } else return name;
    }
}