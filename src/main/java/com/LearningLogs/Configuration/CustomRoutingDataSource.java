package com.LearningLogs.Configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // Return the current data source key, e.g., "dataSource1" or "dataSource2"
        return DataSourceContextHolder.getDataSourceKey();
    }
}
