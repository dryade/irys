/**
 * 
 */
package irys.siri.server.producer.service;

import irys.common.SiriException;
import irys.common.SiriTool;
import lombok.Getter;
import lombok.Setter;
import uk.org.siri.siri.AbstractServiceDeliveryStructure;
import uk.org.siri.siri.OtherErrorStructure;
import uk.org.siri.siri.ServiceDeliveryErrorConditionStructure;

/**
 * @author michel
 *
 */
public abstract class AbstractSiriService
{

   @Getter @Setter private SiriTool siriTool;
	
   public AbstractSiriService()
   {
   }
   
   public void init()
   {
	   
   }
	
   /**
    * add an errocode without setting status false
    * 
    * @param delivery
    * @param errorCode
    * @param errorMsg
    */
   protected void addParameterIgnoredWarning(AbstractServiceDeliveryStructure delivery,  String errorMsg)
   {
      if (delivery.isSetErrorCondition())
      {
         ServiceDeliveryErrorConditionStructure errorCondition = delivery.getErrorCondition();
         OtherErrorStructure error = errorCondition.getOtherError();
         String text = error.getErrorText();
         if (text.contains(SiriException.Code.PARAMETER_IGNORED.toString()))
         {
            text += ","+errorMsg;
            error.setErrorText(text);
            errorCondition.setOtherError(error);
            delivery.setErrorCondition(errorCondition);
         }
      }
      else
      {
         ServiceDeliveryErrorConditionStructure errorCondition = delivery.addNewErrorCondition();
         OtherErrorStructure error = errorCondition.addNewOtherError();
         error.setErrorText("["+SiriException.Code.PARAMETER_IGNORED+"] : "+errorMsg);
      }
   }



}
