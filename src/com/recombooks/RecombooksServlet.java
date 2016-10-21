package com.recombooks;

/**
 * Copyright (c) 2015
 * Recombooks, Inc.
 * All Rights Reserved.
 *
 * Recombooks Private Label
 *
 * Public class:
 *   RecombooksServlet
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecombooksServlet extends HttpServlet {

    Application application = Application.getInstance();

    @Override
    public void init(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> managerInit = executor.submit(new Runnable() {
            @Override
            public void run() {
                application.init();
            }
        });
        executor.shutdown();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Context context = this.application.getContext(request, response, getServletContext());
        application.dispatcher.dispatch(context);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Context context = this.application.getContext(request, response, getServletContext());
        application.dispatcher.dispatch(context);
    }

}
