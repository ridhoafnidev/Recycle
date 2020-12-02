package andre.recycle.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import andre.recycle.Model.ResponseUser;
import andre.recycle.R;
import andre.recycle.Rest.CombineApi;
import andre.recycle.Rest.SampolInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    SampolInterface sampolInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        sampolInterface = CombineApi.getSampolService();

    }

    @OnClick(R.id.btn_login)
    protected void btn_login(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        Call<ResponseUser> responseUserCall = sampolInterface.checkLoginUser(CombineApi.token, email, password);
        responseUserCall.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.body().getKode() == 200) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Salah Asu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.toString());
            }
        });
    }

    @OnClick(R.id.tv_daftar)
    protected void tv_daftar(View view) {
        Intent gotodaftar = new Intent(getApplicationContext(), DaftarActivity.class);
        startActivity(gotodaftar);
    }

    @OnClick(R.id.tv_daftarNasabah)
    protected void tv_daftarNasabah(View view) {
        Intent gotodaftar = new Intent(getApplicationContext(), NasabahActivity.class);
        startActivity(gotodaftar);
    }
}
