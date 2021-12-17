package com.example.booknowassignmenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Sell extends AppCompatActivity {

    TextView date,time,total;
    EditText product,price,unit,quantity,unitType;
    Button save;
    int Price,Quantity;
    float Unit,TotalPrice;
    final String TransactionType = "Sell";
    DataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        date = findViewById(R.id.sell_date_textview);
        time = findViewById(R.id.sell_time_textview);
        product = findViewById(R.id.sell_product);
        price = findViewById(R.id.sell_price);
        unit = findViewById(R.id.sell_unit);
        quantity = findViewById(R.id.sell_total_quantity);
        unitType = findViewById(R.id.sell_add_unit);
        total = findViewById(R.id.sell_total);
        save = findViewById(R.id.sell_save_btn);


        Date c = Calendar.getInstance().getTime();

        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        String formattedDate = df.format(c);
        date.setText(""+formattedDate);
        time.setText(""+currentTime);

        unit.setText(""+1);
        quantity.setText(""+1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTotal();

                //postData(product.getText().toString(), price.getText().toString(),unit.getText().toString(),unitType.getText().toString(),total.getText().toString(),date.getText().toString(),time.getText().toString(),quantity.getText().toString());

                //Sending all data to a model class
                dataStore = new DataStore(date.getText().toString(),time.getText().toString(),product.getText().toString(),price.getText().toString(),unit.getText().toString(),unitType.getText().toString(),total.getText().toString(),TransactionType,quantity.getText().toString());

                //Getting data from model class and sending it to api in json packet
                String uri = "http://9a79-2405-201-3017-1073-f192-7a77-1f7c-c47b.ngrok.io/api/creatTransaction";

                Map<String, String> postParam= new HashMap<String, String>();
                postParam.put("Product name", dataStore.ProductName);
                postParam.put("Price", dataStore.Price);
                postParam.put("Unit", dataStore.Unit);
                postParam.put("Unit Type", dataStore.UnitType);
                postParam.put("Total", dataStore.Total);
                postParam.put("Date", dataStore.Date);
                postParam.put("Time", dataStore.Time);
                postParam.put("Quantity", dataStore.Quantity);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, uri, new JSONObject(postParam), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Tag", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Tag", error.getMessage());
                    }
                });
            }
        });

//        unitType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

//    private void postData(String product_name, String product_price, String Unit, String UnitType, String Total, String Date, String Time,String Quantity){
//    }

    private void calculateTotal(){
        Price = Integer.parseInt(price.getText().toString());
        Quantity = Integer.parseInt(quantity.getText().toString());
        Unit = (float) Double.parseDouble(unit.getText().toString());

        if(Unit == 1){
            TotalPrice = Quantity*Price;
        }
        else if(Unit>1){
            TotalPrice = Quantity*(Price/Unit);
            TotalPrice = Math.round(TotalPrice);
        }
        else
        {
            float value = 1/Unit;
            TotalPrice = Quantity*(Price*value);
        }

        total.setText(""+TotalPrice);


    }
}