package com.example.carrentals;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ToyotaWigo extends AppCompatActivity {
    private TextView mDisplayDate;
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    Spinner DropDownMenu;
    Spinner DropDownMenu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota_wigo);

        getSupportActionBar().setTitle("Fill Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerDropDownMenu();
        DatePicker();

        Button book = findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonListener();
            }
        });
    }

    public void spinnerDropDownMenu(){
        DropDownMenu = findViewById(R.id.spinnerPick);

        List<String> list = new ArrayList<>();
        list.add("PICK UP 1");
        list.add("PICK UP 2");
        list.add("PICK UP 3");
        list.add("PICK UP 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DropDownMenu.setAdapter(adapter);
        DropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ItemValue = parent.getItemAtPosition(position).toString();
                Toast.makeText(ToyotaWigo.this, "Selected " + ItemValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        SECOND
        DropDownMenu1 = findViewById(R.id.spinnerPick1);

        List<String> list1 = new ArrayList<>();
        list1.add("DROP OFF 1");
        list1.add("DROP OFF 2");
        list1.add("DROP OFF 3");
        list1.add("DROP OFF 4");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DropDownMenu1.setAdapter(adapter1);
        DropDownMenu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ItemValue = parent.getItemAtPosition(position).toString();
                Toast.makeText(ToyotaWigo.this, "Selected " + ItemValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onClickButtonListener(){
        Intent intent = new Intent(this, ConfirmBooking.class);
        startActivity(intent);
    }
    public void DatePicker(){
        mDisplayDate = findViewById(R.id.spinnerDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ToyotaWigo.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,month,day,year);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = month + "-" + day + "-" + year;
                mDisplayDate.setText(date);
            }
        };

        mDisplayDate = findViewById(R.id.spinnerDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ToyotaWigo.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,month,day,year);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

//        SECOND
        mDisplayDate1 = findViewById(R.id.spinnerDate1);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ToyotaWigo.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,month,day,year);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = month + "-" + day + "-" + year;
                mDisplayDate1.setText(date);
            }
        };


        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ToyotaWigo.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,month,day,year);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

    }
}
