package com.example.quiz02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbPs5, rbPs4, rbPs3, rbPsvr, rbIndomie, rbMieAyam, rbSiomay;
    private EditText etJam;
    private Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbPs5 = findViewById(R.id.rbPs5);
        rbPs4 = findViewById(R.id.rbPs4);
        rbPs3 = findViewById(R.id.rbPs3);
        rbPsvr = findViewById(R.id.rbPsvr);
        rbIndomie = findViewById(R.id.rbIndomie);
        rbMieAyam = findViewById(R.id.rbMieAyam);
        rbSiomay = findViewById(R.id.rbSiomay);
        etJam = findViewById(R.id.etJam);
        btnPesan = findViewById(R.id.btnPesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungTotal();
            }
        });
    }

    private void hitungTotal() {
        int hargaPerJam = 0;
        int hargaTambahan = 0;
        int waktu = 0;
        int total = 0;

        if (rbPs5.isChecked()) {
            hargaPerJam = 10000;
        } else if (rbPs4.isChecked()) {
            hargaPerJam = 8000;
        } else if (rbPs3.isChecked()) {
            hargaPerJam = 5000;
        } else if (rbPsvr.isChecked()) {
            hargaPerJam = 2000;
        }

        if (rbIndomie.isChecked()) {
            hargaTambahan = 7000;
        } else if (rbMieAyam.isChecked()) {
            hargaTambahan = 10000;
        } else if (rbSiomay.isChecked()) {
            hargaTambahan = 5000;
        }

        try {
            waktu = Integer.parseInt(etJam.getText().toString());
            total = (hargaPerJam * waktu) + hargaTambahan;
            String type = getSelectedRadioButtonText();
            String tambahan = getSelectedTambahanRadioButtonText();
            String waktuStr = etJam.getText().toString();

            // Menampilkan bon/invoice
            Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
            intent.putExtra("type", type);
            intent.putExtra("tambahan", tambahan);
            intent.putExtra("waktu", waktuStr);
            intent.putExtra("total", total);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Masukkan waktu yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    private String getSelectedRadioButtonText() {
        if (rbPs5.isChecked()) {
            return rbPs5.getText().toString();
        } else if (rbPs4.isChecked()) {
            return rbPs4.getText().toString();
        } else if (rbPs3.isChecked()) {
            return rbPs3.getText().toString();
        } else if (rbPsvr.isChecked()) {
            return rbPsvr.getText().toString();
        } else {
            return "";
        }
    }

    private String getSelectedTambahanRadioButtonText() {
        if (rbIndomie.isChecked()) {
            return rbIndomie.getText().toString();
        } else if (rbMieAyam.isChecked()) {
            return rbMieAyam.getText().toString();
        } else if (rbSiomay.isChecked()) {
            return rbSiomay.getText().toString();
        } else {
            return "";
        }
    }
}
