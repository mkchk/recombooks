package com.recombooks;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recombooks.database.DatabaseConnector;
import com.recombooks.database.DatabaseManager;
import com.recombooks.log.BasicLogger;
import com.recombooks.log.Logger;
import com.recombooks.util.Properties;

public class Application {

    private static Application application = new Application();
    protected DatabaseManager     databaseManager;
    protected SessionManager sessionManager;
    protected Dispatcher dispatcher;
    public BasicLogger basicLogger;
    private MemberManager memberManager;
    private RecommendationManager recommendationManager;
    private PropertiesManager propertiesManager;
    private Properties properties;

    public static Application getInstance() {
        return application;
    }

    public Application(){
        basicLogger = new BasicLogger();
        Properties properties = new Properties();
        properties.put("Log.logDirectory","/webapps/logs");
        properties.put("Log.File.On","Yes");
        properties.put("Log.Console.On","Yes");
        basicLogger.configure(properties);
        this.setProperties(properties);
        databaseManager = new DatabaseManager(this,new Logger(basicLogger,"dbmg"));
        sessionManager = new SessionManager(this,new Logger(basicLogger,"ssmg"));
        dispatcher = new Dispatcher(this, new Logger(basicLogger,"dipatchr"));
        memberManager = new MemberManager(this, new Logger(basicLogger, "mbmrmg"));
        recommendationManager = new RecommendationManager(this, new Logger(basicLogger, "rcmrmg"));
        propertiesManager = new PropertiesManager(this, new Logger(basicLogger, "prpty"),properties);

    }

    private void configure(){
        
    }

    void init(){
        propertiesManager.init();
        recommendationManager.init();
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public MemberManager getMemberManager() {
        return memberManager;
    }

    public RecommendationManager getRecommendationManager() {
        return recommendationManager;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public Context getContext(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ServletContext servletContext)
    {
        return new Context(this, request, response, servletContext, dispatcher, new Logger(basicLogger,"ctxt"));
    }

    protected DatabaseConnector constructConnector() {
        return databaseManager.getConnector();
    }

    public DatabaseConnector getConnector() {
        return databaseManager.getConnector();
    }

    public Logger getLog(String componentString) {
        return new Logger(new BasicLogger(), componentString);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
