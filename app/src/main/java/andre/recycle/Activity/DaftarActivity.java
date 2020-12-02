package andre.recycle.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import andre.recycle.Model.ApiLocation;
import andre.recycle.Model.ResponseLocation;
import andre.recycle.Model.UniqueCode;
import andre.recycle.R;
import andre.recycle.Rest.ApiClient;
import andre.recycle.Rest.LocationInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DaftarActivity extends AppCompatActivity {

    Spinner sp_kecamatan, sp_kelurahan;
    String token;
    String TAG = "kambing";
    HashMap<String,String> mapKelurahan;
    HashMap<String,String> mapKecamatan;
    public String BASE_URL="";
    LocationInterface locationInterface;
    ArrayList<ApiLocation> kecamatanArray = new ArrayList<>();
    ArrayList<ApiLocation> kelurahanArray = new ArrayList<>();
    String [] listkecamatan, listkelurahan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_unit);
        mapKecamatan = new HashMap<>();
        mapKelurahan = new HashMap<>();
        sp_kelurahan = (Spinner)findViewById(R.id.spinner_kelurahan);
        sp_kecamatan = (Spinner)findViewById(R.id.spinner_kecamatan);
        loadCodeApi();
        sp_kecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: "+ mapKecamatan.get(listkecamatan[i]));
                loadDesa(mapKecamatan.get(listkecamatan[i]));
//                loadKecamatan(mapKecamatan.get(listkecamatan[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_kelurahan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void loadCodeApi() {
        locationInterface = ApiClient.getClient().create(LocationInterface.class);
        Call<UniqueCode> call = locationInterface.getUniqueCode();
        Log.d(TAG, "loadCodeApi: tes");

        call.enqueue(new Callback<UniqueCode>() {
            @Override
            public void onResponse(Call<UniqueCode> call, Response<UniqueCode> response) {
                token = "MeP7c5ne"+response.body().getUniqueCode();
                Log.d(TAG, "onResponse: "+token);
                loadKecamatan(token);
            }

            @Override
            public void onFailure(Call<UniqueCode> call, Throwable t) {

            }
        });

    }

    private void loadDesa(String s) {
        Log.d(TAG, "loadDesa: "+s);
        Call<ResponseLocation> dataCall = locationInterface.getKelurahanList(token,Integer.parseInt(s));
        dataCall.enqueue(new Callback<ResponseLocation>() {
            @Override
            public void onResponse(Call<ResponseLocation> call, Response<ResponseLocation> response) {
                if (response.isSuccessful()){
                    kelurahanArray = (ArrayList<ApiLocation>) response.body().getData();
                    listkelurahan = new String[kelurahanArray.size()];
                    for (int i = 0; i<listkelurahan.length;i++){
                        listkelurahan[i] = kelurahanArray.get(i).getName();
                        mapKelurahan.put(kelurahanArray.get(i).getName(),kelurahanArray.get(i).getId().toString());
                    }
                    final ArrayAdapter<String> kelurahan_adapter = new ArrayAdapter<>(DaftarActivity.this,R.layout.sp_location,listkelurahan);
                    sp_kelurahan.setAdapter(kelurahan_adapter);
                }
                else{
                    Toast.makeText(DaftarActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                }

                if (response.body().getCode() == 200){
                    kelurahanArray = (ArrayList<ApiLocation>) response.body().getData();
                    listkelurahan = new String[kelurahanArray.size()];
                    for (int i = 0; i<listkelurahan.length;i++){
                        listkelurahan[i] = kelurahanArray.get(i).getName();
                        mapKelurahan.put(kelurahanArray.get(i).getName(),kelurahanArray.get(i).getId().toString());
                    }
                    final ArrayAdapter<String> kelurahan_adapter = new ArrayAdapter<>(DaftarActivity.this,R.layout.sp_location,listkelurahan);
                    sp_kelurahan.setAdapter(kelurahan_adapter);
                }
                else{

                }

            }

            @Override
            public void onFailure(Call<ResponseLocation> call, Throwable t) {
                Log.d(TAG, "onFailureProv: "+t.toString());
            }
        });
    }

    private void loadKecamatan(String s) {
        Call<ResponseLocation> dataCall = locationInterface.getKecamatanList(token,1471);
        dataCall.enqueue(new Callback<ResponseLocation>() {
            @Override
            public void onResponse(Call<ResponseLocation> call, Response<ResponseLocation> response) {
                if (response.isSuccessful()){
                    kecamatanArray = (ArrayList<ApiLocation>) response.body().getData();
                    listkecamatan = new String[kecamatanArray.size()];
                    for (int i = 0; i<listkecamatan.length;i++){
                        listkecamatan[i] = kecamatanArray.get(i).getName();
                        mapKecamatan.put(kecamatanArray.get(i).getName(),kecamatanArray.get(i).getId().toString());
                    }
                    final ArrayAdapter<String> kecamatan_adapter = new ArrayAdapter<>(DaftarActivity.this,R.layout.sp_location,listkecamatan);
                    sp_kecamatan.setAdapter(kecamatan_adapter);
                }
                else{
                    Toast.makeText(DaftarActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                }

                if (response.body().getCode() == 200){
                    kecamatanArray = (ArrayList<ApiLocation>) response.body().getData();
                    listkecamatan = new String[kecamatanArray.size()];
                    for (int i = 0; i<listkecamatan.length;i++){
                        listkecamatan[i] = kecamatanArray.get(i).getName();
                        mapKecamatan.put(kecamatanArray.get(i).getName(),kecamatanArray.get(i).getId().toString());
                    }
                    final ArrayAdapter<String> kecamatan_adapter = new ArrayAdapter<>(DaftarActivity.this,R.layout.sp_location,listkecamatan);
                    sp_kecamatan.setAdapter(kecamatan_adapter);
                }
                else{

                }

            }

            @Override
            public void onFailure(Call<ResponseLocation> call, Throwable t) {
                Log.d(TAG, "onFailureProv: "+t.toString());
            }
        });
    }
}
