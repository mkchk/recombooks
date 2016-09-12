package com.recombooks.log;

import java.util.Calendar;


public class ConsoleLogListener
  extends LogListener
{
  public ConsoleLogListener(int threshhold)
  {
    setDebugThreshold(threshhold);
  }

  public void log(String componentCode, String debugString, int debugLevel)
  {
    if (debugLevel >= getDebugThreshold())
    {
      debugToConsole(componentCode, debugString, debugLevel);
    }
  }
  

  protected void debugToConsole(String componentCode, String debugString)
  {
    debugToConsole(componentCode, debugString, 50);
  }

  protected void debugToConsole(String componentCode, String debugString, int debugLevel)
  {
    this.cal = Calendar.getInstance();

    StringBuffer buffer = new StringBuffer(100);
    buffer.append(generateBriefTimestamp());
    buffer.append(' ');
    buffer.append(componentCode);
    buffer.append(": ");
    buffer.append(debugString);

    System.out.println(buffer.toString());
  }
}
