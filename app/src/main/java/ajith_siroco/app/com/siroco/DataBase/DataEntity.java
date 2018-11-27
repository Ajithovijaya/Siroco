package ajith_siroco.app.com.siroco.DataBase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "Message_Table")
public class DataEntity {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int msgid;
    String message;
    String time,day;
    boolean recieved=true;



    public String getMessage() {
        return message;
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public boolean getType() {
        return recieved;
    }

    public String getDay() {
        return day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    public void setType(Boolean type )
    {
        this.recieved=type;
    }


    public void setMsgid(@NonNull int msgid) {
//        this.msgid
    }
}
