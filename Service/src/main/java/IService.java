/**
 * Created by emirk on 06/05/2015.
 */
public interface IService <T> {
    void getDataFromSource(); // add parameters to fit the route request, lat.long.time, etc
    T validateDataFetched(T data);
    T pushDataToQueue(T data );
}
