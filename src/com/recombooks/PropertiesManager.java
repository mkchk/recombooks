package com.recombooks;

import java.util.HashMap;

import com.recombooks.database.DatabaseConnector;
import com.recombooks.log.Logger;
import com.recombooks.util.Properties;

public class PropertiesManager {

    private  Application  application;
    private Logger log;
    private Properties properties;

    public static String BOOK_LIMIT = "bookLimit";
    public static String RECOMMENDER_LIMIT = "recommenderLimit";

    public PropertiesManager(Application application, Logger logger, Properties properties){
        this.application = application;
        this.log = logger;
        this.properties = properties;
    }

    public void init(){

        DatabaseConnector dbConn = application.getConnector();
        dbConn.setQuery("SELECT bookLimit"
                + "           , recommenderLimit"
                + "        FROM properties;");
        dbConn.runQuery();

        while (dbConn.more()) {

            
            int recommenderLimit = dbConn.getInt(RECOMMENDER_LIMIT);

            int bookLimit = dbConn.getInt(BOOK_LIMIT);

            properties.put(BOOK_LIMIT, ""+bookLimit);

            properties.put(RECOMMENDER_LIMIT, ""+recommenderLimit);

            dbConn.next();
        }

        dbConn.close();

    }
}
