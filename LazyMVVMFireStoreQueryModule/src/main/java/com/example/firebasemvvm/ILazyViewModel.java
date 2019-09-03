package com.example.firebasemvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

public interface ILazyViewModel {
    void init(int RequestCode);

    // this is the only Query I used for the Activity and the 2 fragments
    LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode);

    /*
         Where Greater Than Or Equal To
         */
    LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereGreaterThanOrEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode);

    /*
        Where Less Than Or Equal To
        */
    LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereLessThanOrEqualTo(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode);

    /*
        Where Greater Than
        */
    LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereGreaterThan(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode);

    /*
        Where Less Than
        */
    LiveData<DataOrException<List<QueryDocumentSnapshot>>> getDataWhereLessThan(@NonNull String CollectionPath, @NonNull String QueryFiled, @NonNull Object Value, @NonNull int RequestCode);
}
