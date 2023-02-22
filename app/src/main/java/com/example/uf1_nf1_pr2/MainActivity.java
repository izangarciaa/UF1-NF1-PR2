package com.example.uf1_nf1_pr2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Button mBtnRegistrar, mBtnLogin, mBtnLista;

    private FirebaseDatabase mDatabase;

    private DatabaseReference mReference;

    private ItemViewModel mItemModelView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicialitzem la variable de tipus ModelView
        mItemModelView = new ViewModelProvider(this).get(ItemViewModel.class);
        InicialitzarComponents();
        //Consultar el valor del VIewModel
        mItemModelView.getDadesLiveData().observe(this, itemObservat -> {
            // mTvDadesCompartides.setText(itemObservat);
        });

        CarregaFragment(new Fragment1());
        CarregaFragment(new Fragment2());


        mBtnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
        mBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Carreguem el fragment 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContingutFragments, new Fragment1())
                        .commit();
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContingutFragments, new Fragment2())
                        .commit();
            }
        });
    }

    private void CarregaFragment(Fragment1 fragment1) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContingutFragments, new Fragment1())
                .commit();
    }

    private void CarregaFragment(Fragment2 fragment2) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContingutFragments, new Fragment2())
                .commit();
    }

    private void InicialitzarComponents() {

        mBtnRegistrar = findViewById(R.id.BTN_Fragment1);
        mBtnLogin = findViewById(R.id.BTN_Fragment2);
        mBtnLista = findViewById(R.id.BTN_LISTA);


        mDatabase = FirebaseDatabase.getInstance("https://izan-pr2-default-rtdb.europe-west1.firebasedatabase.app/");
        mReference = mDatabase.getReference();
    }

    private void InicialitzarListeners() {
        mBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}

