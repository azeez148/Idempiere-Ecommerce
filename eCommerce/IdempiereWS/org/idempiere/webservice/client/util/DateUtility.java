package org.idempiere.webservice.client.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author srigin.ms
 *
 */
public class DateUtility {

	/**
	 * Formated Date 
	 * @return
	 */
	public static String calcDate() {
	    SimpleDateFormat date_format = new SimpleDateFormat("dd_MM_yyyy_hh.mm.ss");
	    Date resultdate = new Date();
	    return date_format.format(resultdate);
	  }
	
}
