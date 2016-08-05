package com.recombooks.log;

import com.recombooks.util.Helper;


public class Logger
{
    protected BasicLogger internalLog;

    protected String componentCode;

    public Logger(BasicLogger log, String componentCode)
    {
      this.internalLog = log;
      this.componentCode = componentCode;
    }

    public void debug(String debugString, int debugLevel)
    {
      this.internalLog.log(this.componentCode, debugString, debugLevel);
    }

    public void debug(String debugString)
    {
      this.internalLog.log(this.componentCode, debugString, 50);
    }

    public void debug(String debugString, int debugLevel, Throwable exc)
    {
      log(debugString + Helper.exceptionToString(exc), 
        debugLevel);
    }

    public void debug(String debugString, Throwable exc)
    {
      log(debugString + Helper.exceptionToString(exc), 
        50);
    }

    public void log(String logString, int debugLevel)
    {
      this.internalLog.log(this.componentCode, logString, debugLevel);
    }

    public void log(String logString)
    {
      this.internalLog.log(this.componentCode, logString, 50);
    }

    public BasicLogger getApplicationLog()
    {
      return this.internalLog;
    }

    public String getComponentCode()
    {
      return this.componentCode;
    }

    public void setComponentCode(String code)
    {
      this.componentCode = code;
    }
  }
