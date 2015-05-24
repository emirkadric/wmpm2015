package com.workflow2015.common;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kumar on 23/05/15.
 */

public class DecisionMaker {

    public String decide(List<Exchange> exchanges)
    {
        //todo map exchange to services and make decision
        return "Fetched all "+exchanges.size()+" services.. now need to make decision";

    }
}
