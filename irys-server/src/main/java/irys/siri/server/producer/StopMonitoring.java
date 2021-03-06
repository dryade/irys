/**
 *   Siri Product - Produit SIRI
 *  
 *   a set of tools for easy application building with 
 *   respect of the France Siri Local Agreement
 *
 *   un ensemble d'outils facilitant la realisation d'applications
 *   respectant le profil France de la norme SIRI
 * 
 *   Copyright DRYADE 2009-2010
 */
package irys.siri.server.producer;


import irys.common.SiriException;
import irys.siri.server.data.ServiceBean;
import irys.siri.server.data.SubscriberBean;

import java.util.Calendar;
import uk.org.siri.siri.AccessNotAllowedErrorStructure;
import uk.org.siri.siri.ContextualisedRequestStructure;
import uk.org.siri.siri.ErrorDescriptionStructure;
import uk.org.siri.siri.MessageQualifierStructure;
import uk.org.siri.siri.ServiceDeliveryErrorConditionStructure;
import uk.org.siri.siri.StopMonitoringDeliveriesStructure;
import uk.org.siri.siri.StopMonitoringDeliveryStructure;
import uk.org.siri.siri.StopMonitoringMultipleRequestStructure;
import uk.org.siri.siri.StopMonitoringRequestStructure;
import uk.org.siri.siri.StopMonitoringSubscriptionStructure;
import uk.org.siri.siri.SubscriptionResponseBodyStructure;


/**
 * Implémentation du service CheckStatus
 */
public class StopMonitoring extends AbstractSiri implements StopMonitoringInterface
{

    @Override
    public StopMonitoringDeliveriesStructure getStopMonitoringDeliveries(ContextualisedRequestStructure serviceRequestInfo, StopMonitoringRequestStructure request, Calendar responseTimestamp) throws SiriException {
        StopMonitoringDeliveriesStructure answer = StopMonitoringDeliveriesStructure.Factory.newInstance();

        StopMonitoringDeliveryStructure delivery = answer.addNewStopMonitoringDelivery();
        delivery.setResponseTimestamp(responseTimestamp);
        delivery.setVersion(request.getVersion());
        ServiceDeliveryErrorConditionStructure errorCondition = delivery.addNewErrorCondition();
        ErrorDescriptionStructure description = errorCondition.addNewDescription();
        description.setStringValue("Erreur simulée");

        // ServiceNotAvailableError
        AccessNotAllowedErrorStructure serviceNotAvailableError = errorCondition.addNewAccessNotAllowedError();
        serviceNotAvailableError.setErrorText("[INTERNAL_ERROR] : Service unavailable");

        return answer;
    }

    @Override
    public StopMonitoringDeliveriesStructure getMultipleStopMonitoring(ContextualisedRequestStructure serviceRequestInfo, StopMonitoringMultipleRequestStructure request, Calendar responseTimestamp) throws SiriException {
        StopMonitoringDeliveriesStructure answer = StopMonitoringDeliveriesStructure.Factory.newInstance();

        ServiceDeliveryErrorConditionStructure errorCondition = answer.addNewStopMonitoringDelivery().addNewErrorCondition();
        ErrorDescriptionStructure description = errorCondition.addNewDescription();
        description.setStringValue("Erreur simulée");

        // ServiceNotAvailableError
        AccessNotAllowedErrorStructure serviceNotAvailableError = errorCondition.addNewAccessNotAllowedError();
        serviceNotAvailableError.setErrorText("[INTERNAL_ERROR] : Service unavailable");

        return answer;        
    }

    @Override
    public void addSubscription(Calendar responseTimestamp, SubscriptionResponseBodyStructure answer, ServiceBean service, StopMonitoringSubscriptionStructure[] subscriptions, SubscriberBean subscriptor, MessageQualifierStructure requestMessageRef, String notificationAddress) throws SiriException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   

}
