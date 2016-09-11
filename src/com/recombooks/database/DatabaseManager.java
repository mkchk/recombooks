package com.recombooks.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumMap;
import java.util.HashMap;

import com.recombooks.Application;
import com.recombooks.log.Logger;

public class DatabaseManager {

    private final Application application;
    private DatabaseConnector databaseConnector;

    public DatabaseManager(Application application, Logger logger) {
        this.application = application;
        this.databaseConnector = new DatabaseConnector(logger);
    }

    public DatabaseConnector getConnector() {
        return databaseConnector;
    }

    
}
