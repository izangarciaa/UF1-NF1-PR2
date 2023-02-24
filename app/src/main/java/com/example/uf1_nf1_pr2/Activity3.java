package com.example.uf1_nf1_pr2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView mTvNom;
    private ItemViewModel mItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mTvNom = findViewById(R.id.TV_Nom);
        mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        mItemViewModel.getDadesLiveData().observe(this, nom -> {
            Log.d("----", nom);
            mTvNom.setText(nom);
        });
    }
}