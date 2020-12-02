package andre.recycle.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import andre.recycle.Adapter.SampahAdapter;
import andre.recycle.Model.ResponseSampah;
import andre.recycle.R;
import andre.recycle.Rest.CombineApi;
import andre.recycle.Rest.SampolInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampahActivity extends AppCompatActivity {

    @BindView(R.id.rvSampah)
    RecyclerView rvSampah;
    SampolInterface sampolInterface;
    RecyclerView.LayoutManager layoutManager;
    SampahAdapter sampahAdapter;
    ArrayList sampah = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampah);
        ButterKnife.bind(SampahActivity.this);
        sampolInterface = CombineApi.getSampolService();
        layoutManager = new LinearLayoutManager(SampahActivity.this, LinearLayoutManager.VERTICAL, false);
        rvSampah.setLayoutManager(layoutManager);
        loadSampah();

        FloatingActionButton floatingActionButton=findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoaddsampah = new Intent(getApplicationContext(), AddSampahActivity.class);
                startActivity(gotoaddsampah);
            }
        });

    }

    private void loadSampah() {
        retrofit2.Call<ResponseSampah> responseSampahCall = sampolInterface.listSampah();
        responseSampahCall.enqueue(new Callback<ResponseSampah>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseSampah> call, Response<ResponseSampah> response) {
                if (response.body().getKode() == 200){
                    sampah = (ArrayList) response.body().getSampah();
                    sampahAdapter  = new SampahAdapter(getApplicationContext(), sampah);
                    rvSampah.setAdapter(sampahAdapter);
                    sampahAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(SampahActivity.this, "P", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSampah> call, Throwable t) {
                Log.d("pante", "onFailure: "+t.toString());
            }
        });
    }
}
