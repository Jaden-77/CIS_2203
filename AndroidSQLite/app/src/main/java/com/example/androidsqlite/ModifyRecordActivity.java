package com.example.androidsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModifyRecordActivity extends AppCompatActivity {

    EditText enterBookTitle2, enterBookAuthor2, enterBookPages2;
    Button updateRecordButton, deleteRecordButton;

    String getBookId, getBookTitle, getBookAuthor, getBookPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modify_record);

        enterBookTitle2 = findViewById(R.id.enterbooktitile2);
        enterBookAuthor2 = findViewById(R.id.enterbookauthor2);
        enterBookPages2 = findViewById(R.id.enterbookpages2);

        getandSetSelectedIntentData();

        updateRecordButton = findViewById(R.id.updaterecordbutton);
        updateRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        deleteRecordButton = findViewById(R.id.deleterecordbutton);
        deleteRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void getandSetSelectedIntentData() {
        if (getIntent().hasExtra("modify_book_id") && getIntent().hasExtra("modify_book_title") && getIntent().hasExtra("modify_book_author") && getIntent().hasExtra("modify_book_pages")) {
            getBookId = getIntent().getStringExtra("modify_book_id");
            getBookTitle = getIntent().getStringExtra("modify_book_title");
            getBookAuthor = getIntent().getStringExtra("modify_book_author");
            getBookPages = getIntent().getStringExtra("modify_book_pages");

            enterBookTitle2.setText(getBookTitle);
            enterBookAuthor2.setText(getBookAuthor);
            enterBookPages2.setText(getBookPages);
        } else {
            Toast.makeText(this, "No Record Data!", Toast.LENGTH_SHORT).show();
        }
    }
}