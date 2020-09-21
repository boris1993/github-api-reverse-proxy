package com.boris1993.ghrevproxy;

import cn.leancloud.AVCloud;
import cn.leancloud.LeanEngine;
import cn.leancloud.core.AVOSCloud;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class AppInitListener implements ServletContextListener {

  private static final Logger logger = LogManager.getLogger(AppInitListener.class);

  private final String appId = System.getenv("LEANCLOUD_APP_ID");
  private final String appKey = System.getenv("LEANCLOUD_APP_KEY");
  private final String appMasterKey = System.getenv("LEANCLOUD_APP_MASTER_KEY");
  private final String appEnv = System.getenv("LEANCLOUD_APP_ENV");
  private final String haveStaging = System.getenv("LEAN_CLI_HAVE_STAGING");

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    logger.info("LeanEngine app init. ");

    if ("development".equals(appEnv) && "true".equals(haveStaging) || "stage".equals(appEnv)) {
      AVCloud.setProductionMode(false);
    }

    // 初始化AVOSCloud，请保证在整个项目中间只初始化一次
    LeanEngine.initialize(appId, appKey, appMasterKey, null);

    // 开启强制HTTPS
    LeanEngine.setHttpsRedirectEnabled(true);

  }
}
