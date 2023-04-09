package com.github.sonus21.readwrite.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DatabaseRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContext.get();
    }
}
