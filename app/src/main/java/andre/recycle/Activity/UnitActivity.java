package andre.recycle.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import andre.recycle.Adapter.UnitAdapter;
import andre.recycle.Model.ResponseUnit;
import andre.recycle.R;
import andre.recycle.Rest.CombineApi;
import andre.recycle.Rest.SampolInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitActivity extends AppCompatActivity {

    @BindView(R.id.rvUnit)
    RecyclerView rvUnit;
    SampolInterface sampolInterface;
    RecyclerView.LayoutManager layoutManager;
    UnitAdapter unitAdapter;
    ArrayList unit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        ButterKnife.bind(UnitActivity.this);
        sampolInterface = CombineApi.getSampolService();
        layoutManager = new LinearLayoutManager(UnitActivity.this, LinearLayoutManager.VERTICAL, false);
        rvUnit.setLayoutManager(layoutManager);
        loadUnit();
    }

    private void loadUnit() {
        Call<ResponseUnit> responseUnitCall = sampolInterface.listUnit();
        responseUnitCall.enqueue(new Callback<ResponseUnit>() {
            @Override
            public void onResponse(Call<ResponseUnit> call, Response<ResponseUnit> response) {
                if (response.body().getKode() == 200){
                    unit = (ArrayList) response.body().getUnit();
                    unitAdapter  = new UnitAdapter(getApplicationContext(), unit);
                    rvUnit.setAdapter(unitAdapter);
                    unitAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(UnitActivity.this, "P", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUnit> call, Throwable t) {
                Log.d("pante", "onFailure: "+t.toString());
            }
        });
    }
}
