package exxonmobil.utils;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
// --- <<IS-END-IMPORTS>> ---

public final class date

{
	// ---( internal utility methods )---

	final static date _instance = new date();

	static date _newInstance() { return new date(); }

	static date _cast(Object o) { return (date)o; }

	// ---( server methods )---




	public static final void stringToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateString
		// [i] field:0:required dateFormat
		// [o] object:0:required date
		// Create a SimpleDateFormat object to parse the date
		
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	dateString = IDataUtil.getString( pipelineCursor, "dateString" );
			String	dateFormat = IDataUtil.getString( pipelineCursor, "dateFormat" );
		
		pipelineCursor.destroy();
		
		
		SimpleDateFormat dateFormatObj = new SimpleDateFormat(dateFormat);
		
		try {
		    // Parse the string to get a java.util.Date object
		    Date utilDate = dateFormatObj.parse(dateString);
		
		    // Convert the java.util.Date to java.sql.Date
		    //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		    
			// pipeline
			IDataCursor pipelineCursor_1 = pipeline.getCursor();
			IDataUtil.put( pipelineCursor_1, "date", utilDate );
			pipelineCursor_1.destroy();
		
		} catch (Exception e) {
		    // Handle parsing errors, if any
		    throw new ServiceException(e);
		}
			
			
		// --- <<IS-END>> ---

                
	}
}

