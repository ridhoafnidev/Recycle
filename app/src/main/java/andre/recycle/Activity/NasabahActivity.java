package andre.recycle.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import andre.recycle.R;

public class NasabahActivity extends AppCompatActivity {

    Button date;
    EditText txtDate;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasabah);

        date = (Button) findViewById(R.id.date);
        txtDate = (EditText) findViewById(R.id.etTgl);
        date.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}