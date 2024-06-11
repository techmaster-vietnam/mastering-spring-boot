package vn.techmaster.webmvc;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class WebMvcStartUp {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);
        tomcat.addWebapp(
            "/",
            new File(webappDirLocation).getAbsolutePath()
        );
        tomcat.start();
        System.out.println("server started");
        tomcat.getServer().await();
    }
}
