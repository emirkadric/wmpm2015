import com.workflow2015.common.helper.RouteRequest;

/**
 * Created by emirk on 06/05/2015.
 */
public interface IService<T> {
    void getDataFromSource(RouteRequest routeRequest); // add parameters to fit the route request, lat.long.time, etc

    T validateDataFetched(T data);

    T pushDataToQueue(T data);
}
