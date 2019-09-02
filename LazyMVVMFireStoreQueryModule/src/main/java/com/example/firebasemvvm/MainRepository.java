package com.example.firebasemvvm;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

 class MainRepository {
    private static MainRepository instance;
    public static MainRepository getInstance() {
        if (instance == null) {
            instance = new MainRepository();
        }
        return instance;
    }

        /*
        *
        *
        *
        Where Equal To
        *
        *
        *
        */

    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getQueryResultWhereEqualTo(@NonNull String CollectionPath, @NonNull  String QueryFiled, @NonNull Object Value) {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(CollectionPath);
        Query query = collectionReference.whereEqualTo(QueryFiled, Value);
        final MutableLiveData<DataOrException<List<QueryDocumentSnapshot>>> ListCategoryItems = new MutableLiveData<>();


        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                final DataOrException<List<QueryDocumentSnapshot>> listDataOrException = new DataOrException<>();
                if (queryDocumentSnapshots != null && e == null) {
                    ArrayList<QueryDocumentSnapshot> tempModel = new ArrayList<>();

                    for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                        tempModel.add(snap);
                        listDataOrException.setData(tempModel);

                    }
                    SendLog("List side "+String.valueOf(tempModel.size()));
                    ListCategoryItems.setValue(listDataOrException);
                } else {
                    SendLog("there is an exception");
                    listDataOrException.setException(e);
                    ListCategoryItems.setValue(listDataOrException);
                }
            }
        });
        return ListCategoryItems;
    }
    /*
  *
  *
  *
  Where Greater Than Or Equal To
  *
  *
  *
  */
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getQueryResultWhereGreaterThanOrEqualTo(@NonNull String CollectionPath,@NonNull  String QueryFiled, @NonNull Object Value) {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(CollectionPath);
        Query query = collectionReference.whereGreaterThanOrEqualTo(QueryFiled, Value);
        final MutableLiveData<DataOrException<List<QueryDocumentSnapshot>>> ListCategoryItems = new MutableLiveData<>();
        final DataOrException<List<QueryDocumentSnapshot>> listDataOrException = new DataOrException<>();

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && e == null) {
                    ArrayList<QueryDocumentSnapshot> tempModel = new ArrayList<>();

                    for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                        tempModel.add(snap);
                        listDataOrException.setData(tempModel);

                    }
                    ListCategoryItems.setValue(listDataOrException);

                } else {
                    listDataOrException.setException(e);
                    ListCategoryItems.setValue(listDataOrException);
                }
            }
        });
        return ListCategoryItems;
    }

    /*
*
*
*
Where Less Than Or Equal To
*
*
*
*/
    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getQueryResultWhereLessThanOrEqualTo(@NonNull String CollectionPath,@NonNull  String QueryFiled,@NonNull Object Value) {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(CollectionPath);
        Query query = collectionReference.whereLessThanOrEqualTo(QueryFiled, Value);
        final MutableLiveData<DataOrException<List<QueryDocumentSnapshot>>> ListCategoryItems = new MutableLiveData<>();
        final DataOrException<List<QueryDocumentSnapshot>> listDataOrException = new DataOrException<>();

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && e == null) {
                    ArrayList<QueryDocumentSnapshot> tempModel = new ArrayList<>();

                    for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                        tempModel.add(snap);
                        listDataOrException.setData(tempModel);

                    }
                    ListCategoryItems.setValue(listDataOrException);
                } else {
                    listDataOrException.setException(e);
                    ListCategoryItems.setValue(listDataOrException);
                }
            }
        });
        return ListCategoryItems;
    }

    /*
    *
    *
    *
  Where Greater Than
  *
  *
  */

    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getQueryResultWhereGreaterThan(@NonNull String CollectionPath,@NonNull  String QueryFiled, @NonNull Object Value) {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(CollectionPath);
        Query query = collectionReference.whereGreaterThan(QueryFiled, Value);
        final MutableLiveData<DataOrException<List<QueryDocumentSnapshot>>> ListCategoryItems = new MutableLiveData<>();
        final DataOrException<List<QueryDocumentSnapshot>> listDataOrException = new DataOrException<>();

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && e == null) {
                    ArrayList<QueryDocumentSnapshot> tempModel = new ArrayList<>();

                    for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                        tempModel.add(snap);
                        listDataOrException.setData(tempModel);

                    }
                    ListCategoryItems.setValue(listDataOrException);
                } else {
                    listDataOrException.setException(e);
                    ListCategoryItems.setValue(listDataOrException);
                }
            }
        });
        return ListCategoryItems;
    }

        /*
    *
    *
    *
  Where Less Than
  *
  *
  */

    public LiveData<DataOrException<List<QueryDocumentSnapshot>>> getQueryResultWhereLessThan(@NonNull String CollectionPath,@NonNull  String QueryFiled, @NonNull Object Value) {
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection(CollectionPath);
        Query query = collectionReference.whereLessThan(QueryFiled, Value);
        final MutableLiveData<DataOrException<List<QueryDocumentSnapshot>>> ListCategoryItems = new MutableLiveData<>();
        final DataOrException<List<QueryDocumentSnapshot>> listDataOrException = new DataOrException<>();

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && e == null) {
                    ArrayList<QueryDocumentSnapshot> tempModel = new ArrayList<>();

                    for (QueryDocumentSnapshot snap : queryDocumentSnapshots) {
                        tempModel.add(snap);
                        listDataOrException.setData(tempModel);

                    }
                    ListCategoryItems.setValue(listDataOrException);
                } else {
                    listDataOrException.setException(e);
                    ListCategoryItems.setValue(listDataOrException);
                }
            }
        });
        return ListCategoryItems;
    }

    public void SendLog(String message){
        Log.i("mylog_Repo",message);
    }
}
