package rs.ac.uns.ftn.informatika.jpa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompare {
    private Date Tomorrow;
    
    public DateCompare(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Tomorrow = calendar.getTime();
    }

    public Date getTomorrow(){
        return Tomorrow;
    }
    public void setTomorrow(Date date){
        Tomorrow=date;
    }
    public Boolean compareDates(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date).equals(sdf.format(Tomorrow));
    }
}
