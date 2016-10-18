package com.recombooks;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.recombooks.log.Logger;

public class SessionManager
implements HttpSessionBindingListener
{
    protected int timeoutSeconds = 3600;
    protected int peakSessions = 0;
    protected int countingMinimum = 100;
    protected int countingBy = 25;
    protected int lastLoggedCount = 0;
    protected Application application;
    protected Logger log;
    protected Set sessionSet;
    protected long sessionAccumulator = 0L;


    public SessionManager(Application application, Logger smg)
    {
        this.application = application;
        this.log = smg;
        this.sessionSet = Collections.synchronizedSet(new HashSet(100));
    }

    public void setTimeoutMinutes(int minutes)
    {
        this.timeoutSeconds = (minutes * 60);
    }

    public void setTimeoutSeconds(int seconds)
    {
        this.timeoutSeconds = seconds;
    }

    public void valueBound(HttpSessionBindingEvent event)
    {
        this.sessionSet.add(event.getSession());

        int currentSize = this.sessionSet.size();
        if (currentSize > this.peakSessions)
        {
            this.peakSessions = currentSize;
        }

        logSessionCount(currentSize);
    }


    public void valueUnbound(HttpSessionBindingEvent event)
    {
        this.sessionSet.remove(event.getSession());
    }


    protected void logSessionCount(int sessionCount)
    {
        if ((sessionCount >= this.countingMinimum) && 
                (sessionCount != this.lastLoggedCount) && 
                (sessionCount % this.countingBy == 0))
        {

            this.log.log(sessionCount + " active sessions; " + this.peakSessions + " peak.");
        }
    }

    public int getActiveSessionCount()
    {
        return this.sessionSet.size();
    }




    public int getPeakSessionCount()
    {
        return this.peakSessions;
    }


    public HttpSession getSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);

        if (session.isNew())
        {
            session.setMaxInactiveInterval(this.timeoutSeconds);
        }

        return session;
    }





    public String constructSessionID()
    {
        StringBuffer sessionID = new StringBuffer(13);

        this.sessionAccumulator += 1L;
        String sessionSequenceNumber = Long.toString(this.sessionAccumulator, 36);
        for (int i = sessionSequenceNumber.length(); i < 5; i++)
        {
            sessionID.append('0');
        }
        sessionID.append(sessionSequenceNumber);


        String timeStamp = Long.toString(System.currentTimeMillis(), 36);
        for (int i = timeStamp.length(); i < 8; i++)
        {
            sessionID.append('0');
        }
        sessionID.append(timeStamp);

        return sessionID.toString();
    }
}
