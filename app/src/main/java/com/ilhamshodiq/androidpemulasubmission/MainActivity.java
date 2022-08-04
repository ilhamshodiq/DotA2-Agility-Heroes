package com.ilhamshodiq.androidpemulasubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String title = "Dota 2 Heroes : Agility";
    private RecyclerView rvContents;
    private ArrayList<Content> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);


        rvContents = findViewById(R.id.rv_heroes);
        rvContents.setHasFixedSize(true);

        list.addAll(ContentsData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvContents.setLayoutManager(new LinearLayoutManager(this));
        CardViewContentAdapter cardViewContentAdapter = new CardViewContentAdapter(list);
        rvContents.setAdapter(cardViewContentAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(moveIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}