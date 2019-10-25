package com.example.santos_labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, countries ,industries, ceos, des;
    ListView lstcompany;

    int[] logo = {R.drawable.icbc, R.drawable.jpm, R.drawable.ccb, R.drawable.abc, R.drawable.boa, R.drawable.apple, R.drawable.ping, R.drawable.boc, R.drawable.shell, R.drawable.well, R.drawable.ex, R.drawable.at, R.drawable.sam, R.drawable.citi};

    ArrayList<CompanyDetails> details = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        names = getResources().getStringArray(R.array.company);
        countries = getResources().getStringArray(R.array.country);
        industries = getResources().getStringArray(R.array.industry);
        ceos = getResources().getStringArray(R.array.CEO);
        des = getResources().getStringArray(R.array.desc);

        for(int i = 0; i < names.length; i++){
            details.add(new CompanyDetails(names[i], countries[i], industries[i], ceos[i], logo[i]));
        }
        CompanyAdaptor adapter = new CompanyAdaptor(this, R.layout.item, details);
        lstcompany = findViewById(R.id.lvCompany);
        lstcompany.setAdapter(adapter);
        lstcompany.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(names[i]);
        dialog.setMessage(des[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //Toast.makeText(MainActivity.this, names[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();

    }
}
