package andre.recycle.Rest;

import andre.recycle.Model.ResponseSampah;
import andre.recycle.Model.ResponseUnit;
import andre.recycle.Model.ResponseUser;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SampolInterface {
    @FormUrlEncoded
    @POST("users/{token}")
    Call<ResponseUser> checkLoginUser(@Path("token") String token,
                                      @Field("email") String email,
                                      @Field("password") String password);


    @GET("list_unit")
    Call<ResponseUnit> listUnit();

    @GET("list_sampah")
    Call<ResponseSampah> listSampah();

    @FormUrlEncoded
    @POST("addSampah")
    Call<ResponseSampah> add_sampah(@Field("sampah_nama")
                                            String sampah_nama);

}