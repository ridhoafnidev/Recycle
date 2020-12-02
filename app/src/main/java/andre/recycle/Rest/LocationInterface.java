package andre.recycle.Rest;

import andre.recycle.Model.ResponseLocation;
import andre.recycle.Model.UniqueCode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocationInterface {

    @GET("poe")
    Call<UniqueCode> getUniqueCode();

    @GET("{code}/m/wilayah/kecamatan")
    Call<ResponseLocation> getKecamatanList(@Path("code") String code, @Query("idkabupaten") long idKab);

    @GET("{code}/m/wilayah/kelurahan")
    Call<ResponseLocation> getKelurahanList(@Path("code") String code, @Query("idkecamatan") long idKec);
}
