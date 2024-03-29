package com.example.firebasemvvm;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyViewModel extends ViewModel implements ILazyViewModel {
    private LazyRepository repository;
    private Map<Integer, LazyRepository> repoMap = new HashMap<>();
    private Map<Integer, LiveData<DataOrException<List<QueryDocumentSnapshot>>>> MainModelMap= new HashMap<>();

    @Override
    public void init(int RequestCode) {
        if (!MainModelMap.containsKey(RequestCode)){
            repository = new LazyRepository();
            repoMap.put(RequestCode,repository);
        }
        if (repository == null) {

        }
    }

    public void SendLog(String Message){
        Log.i("mylog_ViewModel",Message);
    }
        /*
    Where Equal To
    */

    // this is the only Query I used for the Activity and the 2 fragments
    @Override
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode) {
         LiveData<DataOrException<List<QueryDocumentSnapshot>>> temp = null;
        if (!MainModelMap.containsKey(RequestCode)){

            temp=repository.getQueryResultWhereEqualTo(CollectionPath, QueryFiled, Value);

            MainModelMap.put(RequestCode,temp);

        }


        return MainModelMap.get(RequestCode);
    }


    /*
     Where Greater Than Or Equal To
     */
    @Override
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereGreaterThanOrEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode) {
        if (!MainModelMap.containsKey(RequestCode)) {

            MainModelMap.put(RequestCode,repository.getQueryResultWhereGreaterThanOrEqualTo(CollectionPath, QueryFiled, Value));
        }
        return MainModelMap.get(RequestCode);
    }


    /*
    Where Less Than Or Equal To
    */
    @Override
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereLessThanOrEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode) {
        if (!MainModelMap.containsKey(RequestCode)) {

            MainModelMap.put(RequestCode,repository.getQueryResultWhereLessThanOrEqualTo(CollectionPath, QueryFiled, Value));
        }
        return MainModelMap.get(RequestCode);

    }



    /*
    Where Greater Than
    */
    @Override
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereGreaterThan(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode) {
        if (!MainModelMap.containsKey(RequestCode)) {

            MainModelMap.put(RequestCode,repository.getQueryResultWhereGreaterThan(CollectionPath, QueryFiled, Value));
        }
        return MainModelMap.get(RequestCode);


    }


    /*
    Where Less Than
    */
    @Override
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereLessThan(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode) {
        if (!MainModelMap.containsKey(RequestCode)) {

            MainModelMap.put(RequestCode,repository.getQueryResultWhereGreaterThan(CollectionPath, QueryFiled, Value));
        }
        return MainModelMap.get(RequestCode);
    }



}
