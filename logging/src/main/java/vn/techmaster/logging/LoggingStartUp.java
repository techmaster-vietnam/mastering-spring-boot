package vn.techmaster.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingStartUp {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(LoggingStartUp.class);
        log.info("hello world");
        log.error("some error", new Exception("test"));
    }
}
