package net.dryade.siri.sequencer.model.type;

public enum RequestStatus 
{
    /**
     * all requests are valid
     */
    OK,
    /**
     * some requests are rejected
     */
    PARTIAL,
    /**
     * no request valid or unknown provider
     */
    FAILED
}
