/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irys.siri.client.features;

import irys.siri.client.common.TimeProviderInterface;

import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author luc
 */
public class TimeProviderMock implements TimeProviderInterface{

    protected Date instanceDate = new Date();
    
    @Override
    public Calendar getCalendarInstance() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instanceDate);
        return calendar;
    }

    @Override
    public Date getDateInstance() {
        return instanceDate;
    }

    @Override
    public String getXmlDate() {
        return DatatypeConverter.printDateTime(getCalendarInstance());
    }
    
}
