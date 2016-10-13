package com.recombooks.util;

import java.util.Hashtable;

public class Properties extends Hashtable<Object,Object>{

    private static final long serialVersionUID = 1L;

    public Properties(){
        super();
    }

    @Override
    public Object put(Object key, Object value) {
        if(key instanceof String) {
            key = ((String)key).toLowerCase();
        }
        return super.put(key, value);
    }

    @Override
    public Object get(Object key) {
        if(key instanceof String) {
            key = ((String)key).toLowerCase();
        }
        return super.get(key);
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return super.containsKey(key instanceof String ? ((String)key).toLowerCase() : key);
    }

    public String getProperty(String key) {
        Object oval = get(key);
        String sval = (oval instanceof String) ? (String)oval : null;
        return sval;
    }

    public long getLongProperty(String name)
    {
      return getLongProperty(name, 0L);
    }

    public long getLongProperty(String name, long defaultValue)
    {
      long toReturn = defaultValue;
      
      try
      {
        toReturn = Long.parseLong(getProperty(name));
      }
      catch (Exception localException) {}

      return toReturn;
    }

    public int getIntegerProperty(String name)
    {
      return getIntegerProperty(name, 0);
    }

    public int getIntegerProperty(String name, int defaultValue)
    {
      int toReturn = defaultValue;
      
      try
      {
        toReturn = Integer.parseInt(getProperty(name).trim());
      }
      catch (Exception localException) {}

      return toReturn;
    }

    public double getDoubleProperty(String name)
    {
      return getDoubleProperty(name, 0.0D);
    }

    public double getDoubleProperty(String name, double defaultValue)
    {
      double toReturn = defaultValue;
      
      try
      {
        toReturn = Double.parseDouble(getProperty(name).trim());
      }
      catch (Exception localException) {}

      return toReturn;
    }

    public float getFloatProperty(String name)
    {
      return getFloatProperty(name, 0.0F);
    }


    public float getFloatProperty(String name, float defaultValue)
    {
      float toReturn = defaultValue;
      
      try
      {
        toReturn = Float.parseFloat(getProperty(name).trim());
      }
      catch (Exception localException) {}

      return toReturn;
    }

    public boolean getYesNoProperty(String name)
    {
      return getYesNoProperty(name, false);
    }

    public boolean getYesNoProperty(String name, boolean defaultValue)
    {
      boolean toReturn = defaultValue;
      
      String prop = getProperty(name);
      if (prop != null)
      {
        if (prop.trim().equalsIgnoreCase("Yes")) {
          toReturn = true;
        } else if (prop.trim().equalsIgnoreCase("No")) {
          toReturn = false;
        }
      }
      return toReturn;
    }

}
