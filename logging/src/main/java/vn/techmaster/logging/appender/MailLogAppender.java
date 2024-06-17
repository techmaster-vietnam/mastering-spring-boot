package vn.techmaster.logging.appender;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.AppenderBase;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MailLogAppender extends AppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent event) {
        Level level = event.getLevel();
        if (level.isGreaterOrEqual(Level.ERROR)) {
            String eceptionDetails = "";
            IThrowableProxy throwable = event.getThrowableProxy();
            if (throwable != null) {
                eceptionDetails += throwable.getMessage();
                eceptionDetails += " " + Stream
                    .of(throwable.getStackTraceElementProxyArray())
                    .map(StackTraceElementProxy::toString)
                    .collect(Collectors.joining());
            }
            System.out.println(
                "sent mail log error: " + event.getFormattedMessage() +
                    ", exception: " + eceptionDetails
            );
        }
    }
}
