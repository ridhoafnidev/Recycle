package andre.recycle.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import andre.recycle.Model.ResponseSampah;
import andre.recycle.R;
import andre.recycle.Rest.CombineApi;
import andre.recycle.Rest.SampolInterface;
import andre.recycle.Utils.SessionManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSampahActivity extends AppCompatActivity {
    SessionManager sessionManager;
    HashMap<String, String> map;
    SampolInterface sampolInterface;
    @BindView(R.id.etNama)
    EditText etNama;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sampah);
        ButterKnife.bind(this);
        sampolInterface = CombineApi.getSampolService();
        sessionManager = new SessionManager(AddSampahActivity.this);
        map = sessionManager.getDetailsLoggin();
    }

    @OnClick(R.id.btnAddSampah)
    protected void btnAddSampah(View view) {

        String nama;
        nama = etNama.getText().toString();
        Log.d("wow", "btnAddSampah: 50"+nama);
        sampolInterface.add_sampah(nama).enqueue(new Callback<ResponseSampah>() {
            @Override
            public void onResponse(Call<ResponseSampah> call, Response<ResponseSampah> response) {
                Log.d("wow", "btnAddSampah: 54"+nama);
                int status = response.body().getKode();
                if (status == 200){Log.d("wow", "btnAddSampah: 56"+nama);
                    Toast.makeText(AddSampahActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent gotosampah = new Intent(AddSampahActivity.this,SampahActivity.class);
                    startActivity(gotosampah);
                }else{
                    Toast.makeText(AddSampahActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSampah> call, Throwable t) {

            }
        });

    }


}
