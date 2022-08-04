package com.ilhamshodiq.androidpemulasubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_COMPLEXITY = "extra_complexity";
    public static final String EXTRA_DETAIL = "extra_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = findViewById(R.id.iv_detail_img);
        TextView detailName = findViewById(R.id.tv_detail_name);
        TextView detailType = findViewById(R.id.tv_detail_type);
        TextView detailComplexity = findViewById(R.id.tv_detail_complexity);
        TextView detailDetail = findViewById(R.id.tv_detail_detail);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        String complexity = getIntent().getStringExtra(EXTRA_COMPLEXITY);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        int photo = getIntent().getIntExtra("int", 0);

        detailImage.setImageResource(photo);
        detailName.setText(name);
        detailType.setText(type);
        detailComplexity.setText(complexity);
        detailDetail.setText(detail);

//        Glide.with(this).load(photo).into(detailImage);


        setActionBarTitle("Detail Hero : " + name);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}