package com.example.quiz02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        // Mendapatkan informasi dari Intent
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String tambahan = intent.getStringExtra("tambahan");
        String waktu = intent.getStringExtra("waktu");
        int total = intent.getIntExtra("total", 0);

        // Menampilkan informasi pada TextView
        TextView typeTextView = findViewById(R.id.typeTextView);
        TextView itemsTextView = findViewById(R.id.itemsTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TextView totalTextView = findViewById(R.id.totalTextView);

        typeTextView.setText("Type: " + type);
        itemsTextView.setText("Tambahan: " + tambahan);
        timeTextView.setText("Waktu: " + waktu + " jam");
        totalTextView.setText("Total Harga: Rp " + total);
    }
}
