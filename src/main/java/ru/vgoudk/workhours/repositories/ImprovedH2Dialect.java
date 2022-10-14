package ru.vgoudk.workhours.repositories;

import org.hibernate.dialect.PostgreSQL10Dialect;

@SuppressWarnings("squid:MaximumInheritanceDepth")//подавление предупреждения о количестве наследников
public class ImprovedH2Dialect extends PostgreSQL10Dialect {
    @Override
    public String getDropSequenceString(String sequenceName) {
        // Adding the "if exists" clause to avoid warnings
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public String getDropTableString(String tableName) {
        return "drop table if exists " + tableName + " cascade constraints";
    }

    @Override
    public boolean dropConstraints() {
        // We don't need to drop constraints before dropping tables, that just
        // leads to error messages about missing tables when we don't have a
        // schema in the database
        return false;
    }

    @Override
    protected String getCreateSequenceString(String sequenceName, int initialValue, int incrementSize) {
        return String.format(
                //language=PostgreSQL
                " CREATE SEQUENCE %s" +
                        " START WITH %d" +
                        " INCREMENT BY %d" +
                        " NO MINVALUE" +
                        " NO MAXVALUE" +
                        " CACHE 1",
                sequenceName, initialValue, incrementSize
        );
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsIfExistsBeforeConstraintName() {
        return true;
    }
}
