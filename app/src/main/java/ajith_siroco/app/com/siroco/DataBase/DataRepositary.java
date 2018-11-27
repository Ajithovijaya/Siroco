package ajith_siroco.app.com.siroco.DataBase;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class DataRepositary {

    LiveData<List<DataEntity>> data;
    DataDAO dataDAO;
    public DataRepositary(Context context)
    {
        RoomDB roomDB=RoomDB.getMessages(context);
        dataDAO=roomDB.datadao();
        data=dataDAO.getAlldata();

    }

    LiveData<List<DataEntity>> getAllData()
    {
        return data;
    }


    public void insert(DataEntity dataEntity) {
        new Insertasync(dataDAO).execute(dataEntity);
    }

    private class Insertasync extends AsyncTask<DataEntity,Void,Void>{

        DataDAO asyncDao;

        public Insertasync(DataDAO dao) {
            this.asyncDao=dao;
        }


        @Override
        protected Void doInBackground(DataEntity... dataEntities)
        {
            asyncDao.insert(dataEntities[0]);

            return null;
        }
    }
}
