package com.example.uf1_nf1_pr2;

public class Usuari {
    private String mNom, mEmail, mPassword, mUid;

    public Usuari() {

    }

    public Usuari(String nom, String email, String password, String uid) {
        mNom = nom;
        mEmail = email;
        mPassword = password;
        mUid = uid;

    }

    public String getmNom() {
        return mNom;
    }

    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmUid() {
        return mUid;
    }

    public void setmUid(String mUid) {
        this.mUid = mUid;
    }

    @Override
    public String toString() {
        return "Usuari: " + mNom + ", Email= " + mEmail + ", Password= " + mPassword;
    }
}


