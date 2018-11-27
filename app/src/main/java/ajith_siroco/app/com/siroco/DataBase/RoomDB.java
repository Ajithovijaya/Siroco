package ajith_siroco.app.com.siroco.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {DataEntity.class},version = 1)
public abstract class RoomDB extends RoomDatabase {
    public abstract DataDAO datadao();
    private static volatile RoomDB roomDB;


    static RoomDB getMessages(Context context)
    {
        if (roomDB==null)
        {
            synchronized (RoomDB.class)
            {
                if (roomDB==null)
                {
                    roomDB= Room.databaseBuilder(context,RoomDB.class,"messsageDb")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
    return roomDB;
    }

}
