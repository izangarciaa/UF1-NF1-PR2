package com.example.uf1_nf1_pr2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView mTvDadesCompartides;
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

//        CarregaFragment1(new Fragment1());
        //CarregaFragment(new Fragment2());


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
                CarregaFragment1(new Fragment1());
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregaFragment2(new Fragment2());
            }
        });
    }

    private void CarregaFragment1(Fragment1 fragment1) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContingutFragments, fragment1)
                .commit();
    }

    private void CarregaFragment2(Fragment2 fragment2) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContingutFragments, fragment2)
                .commit();
    }

    private void InicialitzarComponents() {

        mBtnRegistrar = findViewById(R.id.BTN_Fragment1);
        mBtnLogin = findViewById(R.id.BTN_Fragment2);
        mBtnLista = findViewById(R.id.BTN_LISTA);
        mTvDadesCompartides = findViewById(R.id.ET_Nom);
        mDatabase = FirebaseDatabase.getInstance("https://izan-pr2-default-rtdb.europe-west1.firebasedatabase.app/");
        mReference = mDatabase.getReference();
    }
}




