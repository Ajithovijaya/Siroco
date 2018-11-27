package ajith_siroco.app.com.siroco.DataBase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DataDAO {

    @Insert
    void insert(DataEntity dataEntity);

    @Query("SELECT * from Message_Table")
    LiveData<List<DataEntity>> getAlldata();



}
