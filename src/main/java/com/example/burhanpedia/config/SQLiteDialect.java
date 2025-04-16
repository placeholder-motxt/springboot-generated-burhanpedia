package com.example.burhanpedia.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

import java.sql.Types;
import java.util.Properties;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }


    @Override
    public String getTableTypeString() {
        return "";
    }

    protected void registerColumnTypes(Properties properties) {
        properties.put(Types.BIT, "integer");
        properties.put(Types.TINYINT, "integer");
        properties.put(Types.SMALLINT, "integer");
        properties.put(Types.INTEGER, "integer");
        properties.put(Types.BIGINT, "integer");
        properties.put(Types.REAL, "real");
        properties.put(Types.FLOAT, "real");
        properties.put(Types.DOUBLE, "real");
        properties.put(Types.NUMERIC, "numeric");
        properties.put(Types.DECIMAL, "numeric");
        properties.put(Types.DATE, "text");
        properties.put(Types.TIME, "text");
        properties.put(Types.TIMESTAMP, "text");
        properties.put(Types.VARCHAR, "text");
        properties.put(Types.LONGVARCHAR, "text");
        properties.put(Types.CLOB, "text");
        properties.put(Types.BINARY, "blob");
        properties.put(Types.VARBINARY, "blob");
        properties.put(Types.BLOB, "blob");
        properties.put(Types.LONGVARBINARY, "blob");
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
            @Override
            public String getIdentitySelectString(String table, String column, int type) {
                return "select last_insert_rowid()";
            }

            @Override
            public String getIdentityColumnString(int type) {
                // Returns the column type to be used for auto-increment columns in SQLite.
                return "integer";
            }
        };
    }


    public boolean supportsForeignKeyConstraints() {
        // We disable automatic foreign key constraint DDL generation
        return false;
    }

    @Override
    public String getAddForeignKeyConstraintString(String constraintName,
                                                   String[] foreignKey,
                                                   String referencedTable,
                                                   String[] primaryKey,
                                                   boolean referencesPrimaryKey) {
        // Returning a single space avoids producing an incomplete foreign key clause.
        return " ";
    }

    public String getDropForeignKeyConstraintString(String constraintName) {
        // Similarly, return a single space to avoid an incomplete statement.
        return " ";
    }
}