package com.example.carrentals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.PopupMenu;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button book = findViewById(R.id.btnBook1);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonListener();
            }
        });

        final ImageButton DropDownMenu = findViewById(R.id.btnMenu);

        DropDownMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, DropDownMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Button bookings = findViewById(R.id.bookings);
                        bookings.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onClickBookings();
                            }
                        });
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }

    public void onClickButtonListener(){
        Intent intent = new Intent(this, ToyotaWigo.class);
        startActivity(intent);
    }

    public void onClickBookings(){
    Intent intent = new Intent(this, Bookings.class);
    startActivity(intent);
    }
}
