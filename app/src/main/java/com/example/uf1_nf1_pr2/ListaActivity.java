package com.example.uf1_nf1_pr2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private Button mBtn_MainPage;
    //Si se utilizan listas en android siempre hay que utilizar estas 3 lineas
    private ListView mLvusuarios;
    private List<Usuari> mLlistaUsuaris = new ArrayList<>();
    private ArrayAdapter mAdaptedUsuaris;
    private Usuari mUsuariSeleccionat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        InicialitzarComponents();
        LListarUsuaris();
        mBtn_MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InicialitzarComponents() {
        mBtn_MainPage = findViewById(R.id.BTN_MainPage);
        mDatabase = FirebaseDatabase.getInstance("https://izan-pr2-default-rtdb.europe-west1.firebasedatabase.app/");
        mReference = mDatabase.getReference();
        mLvusuarios = findViewById(R.id.LV_Usuarios);

    }

    private void LListarUsuaris() {
        mReference.child("Usuaris").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mLlistaUsuaris.clear();

                //Omplim la nostra llista d'usuaris a partir del snapshot de Firebase.
                for (DataSnapshot ds : snapshot.getChildren()) {

                    Usuari usuari = ds.getValue(Usuari.class);
                    mLlistaUsuaris.add(usuari);
                }

                //Passem la llista d'usuaris al component ListView de la pantalla.
                mAdaptedUsuaris = new ArrayAdapter<>(ListaActivity.this, android.R.layout.simple_list_item_1, mLlistaUsuaris);
                mLvusuarios.setAdapter(mAdaptedUsuaris);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}