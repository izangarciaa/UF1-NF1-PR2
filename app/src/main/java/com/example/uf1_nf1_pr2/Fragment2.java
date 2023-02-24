package com.example.uf1_nf1_pr2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private EditText mEtEmailFrg2, mEtPasswordFrg2;
    private Button mBtnLoginFrg2;

    private FirebaseDatabase mDatabase;

    private DatabaseReference mReference;

    private ItemViewModel mItemModelView2;

    //Si se utilizan listas en android siempre hay que utilizar estas 3 lineas    private ListView mLvusuarios;

    private List<Usuari> mLlistaUsuaris = new ArrayList<>();
    private ArrayAdapter<Usuari> mAdaptedUsuaris;
    private Usuari mUsuariSeleccionat;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_2, container, false);

        mEtEmailFrg2 = v.findViewById(R.id.ET_Email);
        mEtPasswordFrg2 = v.findViewById(R.id.ET_Password);
        mBtnLoginFrg2 = v.findViewById(R.id.BTN_HacerLogin);
//        Log.d("----", mBtnLoginFrg2.toString());

        mItemModelView2 = new ViewModelProvider(this).get(ItemViewModel.class);
        mDatabase = FirebaseDatabase.getInstance("https://izan-pr2-default-rtdb.europe-west1.firebasedatabase.app/");
        mReference = mDatabase.getReference();
        mBtnLoginFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetCamps();
            }
        });
        return v;
    }

    private void ResetCamps() {
        mEtEmailFrg2.setText("");
        mEtPasswordFrg2.setText("");
    }
}