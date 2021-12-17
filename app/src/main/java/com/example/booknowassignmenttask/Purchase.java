package com.example.booknowassignmenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Purchase extends AppCompatActivity {

    TextView date,time,total;
    EditText product,price,unit,quantity,unitType;
    Button save;
    int Price,Quantity;
    float Unit,TotalPrice;
    final String TransactionType = "Purchase";
    DataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        date = findViewById(R.id.purchase_date_textview);
        time = findViewById(R.id.purchase_time_textview);
        product = findViewById(R.id.purchase_product);
        price = findViewById(R.id.purchase_price);
        unit = findViewById(R.id.purchase_unit);
        quantity = findViewById(R.id.purchase_total_quantity);
        unitType = findViewById(R.id.purchase_add_unit);
        total = findViewById(R.id.purchase_total);
        save = findViewById(R.id.purchase_save_btn);


        Date c = Calendar.getInstance().getTime();

        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        String formattedDate = df.format(c);
        date.setText(""+formattedDate);
        time.setText(""+currentTime);

        unit.setText(""+1);
        quantity.setText(""+1);

    }
}