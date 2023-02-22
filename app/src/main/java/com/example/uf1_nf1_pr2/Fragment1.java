package com.example.uf1_nf1_pr2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Fragment1 extends Fragment {

    private EditText mEtNomFrg1, mEtEmailFrg1, mEtPasswordFrg1;
    private Button mBtnRegistro;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ItemViewModel mItemModelView;


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_1, container, false);

        mEtNomFrg1 = v.findViewById(R.id.ET_Nom);
        mEtEmailFrg1 = v.findViewById(R.id.ET_Email);
        mEtPasswordFrg1 = v.findViewById(R.id.ET_Password);
        mBtnRegistro = v.findViewById(R.id.BTN_Registro);
        mItemModelView = new ViewModelProvider(this).get(ItemViewModel.class);

        mDatabase = FirebaseDatabase.getInstance("https://izan-pr2-default-rtdb.europe-west1.firebasedatabase.app/");
        mReference = mDatabase.getReference();
        mBtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("----", "hola");
                AfegirUsuari();
            }
        });
        return v;
    }


    private void AfegirUsuari() { //Create
        String nom = mEtNomFrg1.getText().toString();
        String email = mEtEmailFrg1.getText().toString();
        String password = mEtPasswordFrg1.getText().toString();
        String uid = UUID.randomUUID().toString();
        Usuari usuari = new Usuari(nom, email, password, uid);

        mReference.child("Usuari").child(uid).setValue(usuari);

        ResetCamps();
    }

    private void ResetCamps() {
        mEtNomFrg1.setText("");
        mEtEmailFrg1.setText("");
        mEtPasswordFrg1.setText("");
    }
}

