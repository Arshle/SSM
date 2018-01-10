/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Initializer.java
 * Author:   zhangdanji
 * Date:     2017年09月24日
 * Description:   
 */
package com.mychebao.initializer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

/**
 * @author zhangdanji
 */
public class Initializer extends HttpServlet {

    private static final long serialVersionUID = -321538889537351162L;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        LoggerContext loggerContext = null;
        if(LoggerContext.class.isInstance(LoggerFactory.getILoggerFactory())){
            loggerContext = LoggerContext.class.cast(LoggerFactory.getILoggerFactory());
        }
        if(loggerContext == null){
            loggerContext = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            loggerContext.getStatusManager().clear();
            loggerContext.reset();
            File logbackFile = new File(this.getClass().getClassLoader().getResource("/").getPath()+this.getInitParameter("logbackName"));
            configurator.doConfigure(logbackFile);
            Logger logger = LoggerFactory.getLogger("com.mychebao");
            logger.info("---logback init success---");
        } catch (JoranException e) {
            e.printStackTrace();
        }
    }
}
