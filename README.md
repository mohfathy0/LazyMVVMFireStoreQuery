# Lazy MVVM FireStore Query
[![](https://jitpack.io/v/mohfathy0/LazyMVVMFireStoreQuery.svg)](https://jitpack.io/#mohfathy0/LazyMVVMFireStoreQuery)

## About:
This is a MVVM ready to use with Firebase FireStore Database Query builder and no need to rewrite the declaration for each Activity or Fragment If you need a new instance of the ViewModel just use new Request code for each Activity or Fragment If you need to get the same exact result and have another Activity or fragment observing the same data just use the same Request Code.
Do not forget to link your application to FireStore and it's dependencies to your project in addition to Step 2

## How to import:
### Step 1
Make sure to add to build.gradle (Project)
```sh
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2
Import the liberaries to your project
```sh
    def lifecycle_version = "2.0.0" /*or whatever is avialable*/
    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"

    def LazyVersion= "1.0.1" /*or whatever is avialable*/
    // Lazy MVVM FireStore Query
   implementation "com.github.mohfathy0:LazyMVVMFireStoreQuery:$LazyVersion"
```


## How to use:

Create your own Models and follow this example in your activity
```sh
 public class MainActivity extends AppCompatActivity {
    private    String CollectionPath = "users";
    private String QueryField="id";
    private int QueryValue=1;
    private int RequestCode=123;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ILazyViewModel viewModel = ViewModelProviders.of(this).get(LazyViewModel.class);
        viewModel.init(RequestCode);
        viewModel.getDataWhereEqualTo(CollectionPath,QueryField,QueryValue,RequestCode).observe(this, new Observer<DataOrException<List<QueryDocumentSnapshot>>>() {
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
```

### Note:
Feel free to create your own class the converts from QueryDocumentSnapshot to whatever you need and start running in within OnChanged and you need to do the necessary validation 
