package com.arju.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arju.sqlite.helper.MyHelper;

public class MainActivity extends AppCompatActivity {
    EditText etword, etmeaning;
    Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etword = findViewById(R.id.etword);
        etmeaning = findViewById(R.id.etmeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener((v) => {
        long id = myHelper.InsertData(etword.getText().toString(), sqLiteDatabase);
        if (id > 0) {
            Toast.makeText(this, "Successful" + id, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }

        });
    }
}
