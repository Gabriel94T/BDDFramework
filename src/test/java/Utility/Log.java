package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Log {
	
	//Logger for methods and classes 
	
	private static Logger Log = LogManager.getLogger(Log.class.getName());


	public static void info (String message) {
	Log.info(message);
	}


	public static void warn (String message) {
	Log.warn(message);
	}


	public static void error (String message) {
	Log.error(message);
	}


	public static void fatal (String message) {
	Log.fatal(message);
	}


	public static void debug (String message) {
	Log.debug(message);
	}
	

}
