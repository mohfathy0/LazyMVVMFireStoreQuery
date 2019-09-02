package com.example.lazymvvmfirestorequery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.firebasemvvm.DataOrException;
import com.example.firebasemvvm.MainViewModel;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private    String CollectionPath = "users";
    private String QueryField="id";
    private int QueryValue=1;
    private int RequestCode=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel m = ViewModelProviders.of(this).get(MainViewModel.class);
        m.init(RequestCode);
        m.getDataWhereEqualTo(CollectionPath,QueryField,QueryValue,RequestCode).observe(this, new Observer<DataOrException<List<QueryDocumentSnapshot>>>() {
            @Override
            public void onChanged(DataOrException<List<QueryDocumentSnapshot>> e) {
                if (e.getData()!=null || e.getException()!=null){
                    for (QueryDocumentSnapshot snap:e.getData()){
                        Log.i("LazyMVVMFireStoreQuery",snap.toObject(UsersModel.class).getFirstName()+snap.toObject(UsersModel.class).getLastName());
                    }
                }else {

                    Log.i("LazyMVVMFireStoreQuery", e.getException().getMessage());
                }

            }
        });
    }
}
