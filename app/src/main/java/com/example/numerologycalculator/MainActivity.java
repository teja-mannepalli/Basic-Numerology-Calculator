package com.example.numerologycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public EditText name;
    public TextView dob;
    public Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView dob;
        dob = findViewById(R.id.dob);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        Button go;
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // submitForm();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                // Intent categoryInt = intent.putExtra("category_int", name_number);
                //Create the bundle
                Bundle bundle = new Bundle();

                final EditText namefield = (EditText) findViewById(R.id.name);
                Log.d("For Loop Activity","name_number = " +name);
                final TextView dob = (TextView) findViewById(R.id.dob);
                String name = namefield.getText().toString();
                String lp = dob.getText().toString();

                Log.d("For Loop Activity","name_number = " +name);

                final int name_number = name_number(name);
                final int soul_urge = soul_urge(name);
                final int lifepath = dob(lp);
                // Log.d("For Loop Activity","name_number = " +namefield);

                //Add your data to bundle
                bundle.putString("life_path", String.valueOf(lifepath));
                bundle.putString("name_number", String.valueOf(name_number));
                bundle.putString("soul_urge", String.valueOf(soul_urge));
                //Add the bundle to the intent
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public int dob(String dob)  {
        int lp = 0;
        Log.d("Date of birth = ", dob);
        String [] dparts = dob.split("-");
        Log.d("Day = ", dparts[0]);
        Log.d("Month = ", dparts[1]);
        Log.d("Year = ", dparts[2]);
        String day = dparts[0];
        String mon = dparts[1];
        String year = dparts[2];
        int month = 0;
        // mon = mon.toLowerCase().trim();
        if (mon.equals("Jan")) {
            month = 1;
        }
        if (mon.equals("Feb")) {
            month = 2;
        }
        if (mon.equals("Mar")) {
            month = 3;
        }
        if (mon.equals("Apr")) {
            month = 4;
        }
        if (mon.equals("May")) {
            month = 5;
        }
        if (mon.equals("Jun")) {
            month = 6;
        }
        if (mon.equals("Jul")) {
            month = 7;
        }
        if (mon.equals("Aug")) {
            month = 8;
        }
        if (mon.equals("Sep")) {
            month = 9;
        }
        if (mon.equals("Oct")) {
            month = 10;
        }
        if (mon.equals("Nov")) {
            month = 11;
        }
        if (mon.equals("Dec")) {
            month = 12;
        }
        lp = Integer.parseInt(day) + month + Integer.parseInt(year);
        //int quotient = lp / 10;
        //int remainder = lp % 10;
        //Log.d("%", String.valueOf(+quotient));
        //Log.d("%", String.valueOf(+remainder));
        int num = lp;
        int lpsd = 0;
        while ((num > 0)) {

            if((num==11)||(num==22)) {
                num = lpsd;
                break;
            }
        else {
                lpsd = (num % 10) + lpsd;
                num = num / 10;
            }
        }
        // lp = lp + Integer.parseInt(dob);
        return lpsd;
    }


    public int soul_urge(String name)  {
        int soul_urge = 0;
        name = name.toLowerCase().trim();
        for(int i = 0;i < name.length(); i++) {

            if (name.charAt(i) == 'a') {
                soul_urge += 1;
            }
            if (name.charAt(i) == 'u') {
                soul_urge += 3; }
            if (name.charAt(i) == 'e') {
                soul_urge += 5; }
            if (name.charAt(i) == 'o') {
                soul_urge += 6; }
            if (name.charAt(i) == 'i') {
                soul_urge += 9; }
        }
    return soul_urge;
    }

    public int name_number(String name)  {
        name = name.toLowerCase().trim();
        int name_number = 0;

        for(int i = 0;i < name.length(); i++)
        {
            if ((name.charAt(i) == 'a')  || (name.charAt(i) == 'j') || (name.charAt(i) == 's')) {
                name_number += 1;

            } else if (name.charAt(i) == 'b' || name.charAt(i) == 'k' || name.charAt(i) == 't') {
                name_number += 2;
            } else if (name.charAt(i) == 'c' || name.charAt(i) == 'l' || name.charAt(i) == 'u') {
                name_number += 3;

            } else if (name.charAt(i) == 'd' || name.charAt(i) == 'm' || name.charAt(i) == 'v') {
                name_number += 4;
            } else if (name.charAt(i) == 'e' || name.charAt(i) == 'n' || name.charAt(i) == 'w') {
                name_number += 5;

            } else if (name.charAt(i) == 'f' || name.charAt(i) == 'o' || name.charAt(i) == 'x') {
                name_number += 6;

            } else if (name.charAt(i) == 'g' || name.charAt(i) == 'p' || name.charAt(i) == 'y') {
                name_number += 7;
            } else if (name.charAt(i) == 'h' || name.charAt(i) == 'q' || name.charAt(i) == 'z') {
                name_number += 8;
            } else if (name.charAt(i) == 'i' || name.charAt(i) == 'r') {
                name_number += 9;

            }
            // Log.d("For Loop Activity","name_number = " +name_number);
        }
        return name_number;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateName()  {
        if (name.getText().toString().trim().isEmpty())  {
            requestFocus(name);
            return false;
        }
        return true;
    }

    private boolean validateDOB()  {
        if (dob.getText().toString().isEmpty()) {
            requestFocus(dob);
            return false;
        }
        return true;
    }

    private void submitForm() {
        if (!validateDOB()) {
            return;
        }
        if (!validateName()) return;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView date = (TextView) findViewById(R.id.dob);
        date.setText(currentDateString);

    }
}
