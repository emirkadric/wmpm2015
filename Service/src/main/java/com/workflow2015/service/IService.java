package com.workflow2015.service;

import com.workflow2015.common.helper.RouteRequest;

/**
 * Created by emirk on 06/05/2015.
 */
public interface IService<T,U> {
    U getDataFromSource(RouteRequest routeRequest); // add parameters to fit the route request, lat.long.time, etc

    T validateDataFetched(U data);

    T pushDataToQueue(U data);
}
