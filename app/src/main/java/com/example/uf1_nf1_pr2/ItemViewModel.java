package com.example.uf1_nf1_pr2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

        private static final MutableLiveData<String> mNom = new MutableLiveData<>();

        public void setDadesLiveData(String nom) {
            Log.d("----", nom);
            mNom.setValue(nom);
        }

        public LiveData<String> getDadesLiveData() {
            return mNom;
        }
    }

