package rs.ac.uns.ftn.informatika.jpa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompare {
    
    private Date Tomorrow;
    
    public DateCompare()
    {
        Calendar calendar = Calendar.getInstance();
        Tomorrow = calendar.getTime();
    }

    public Date getTomorrow()
    {
        return Tomorrow;
    }

    public void setTomorrow(Date date)
    {
        Tomorrow=date;
    }

    public Boolean compareDates(Date date)
    {
        return Tomorrow.after(date);
    }
}
