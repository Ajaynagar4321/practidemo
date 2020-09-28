import java.io.IOException;


import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.annotations.Test;



public class Log4JDemos {

		@Test
		public void testLog4J() throws IOException {
			// configure the log4J
			Layout layout = new PatternLayout("%d %c %m %n");
			Appender appender = new FileAppender(layout, "./reports/r.log");
			BasicConfigurator.configure(appender);
			// get the Object of the log4J
			Logger log = Logger.getLogger(this.getClass().getName());

			// print the message
			log.setLevel(Level.ALL);
			log.warn("warning");
			log.error("error");
			

		}

	}
