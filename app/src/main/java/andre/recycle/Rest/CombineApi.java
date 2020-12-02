package andre.recycle.Rest;

public class CombineApi {

    public static final String BASE_URL = "http://192.168.0.100/sampol/public/api/";
    public static final String img_url = "http://192.168.43.50/sampol/assets/uploads/";
    public static String token = "859c1651341c5a5dab43a141ba4b961e";
    public static final String LOCATION_URL = "https://x.rajaapi.com/";
    public static SampolInterface getSampolService(){
        return ApiClient.getApiClient(BASE_URL).create(SampolInterface.class);
    }
}
