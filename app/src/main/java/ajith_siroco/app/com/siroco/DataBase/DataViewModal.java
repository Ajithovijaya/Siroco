package ajith_siroco.app.com.siroco.DataBase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import java.util.List;

import ajith_siroco.app.com.siroco.Interface.DataaddedListener;

public class DataViewModal extends AndroidViewModel {

    LiveData<List<DataEntity>> data;
    DataRepositary dataRepositary;


    public DataViewModal(@NonNull Application application) {
        super(application);
        dataRepositary=new DataRepositary(application);
        data=dataRepositary.getAllData();
    }

    public LiveData<List<DataEntity>> getAllData()
    {
        return data;
    }


    public void insert(DataEntity dataEntity) {
        dataRepositary.insert(dataEntity);
    }
}
