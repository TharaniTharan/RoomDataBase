package kaptas.com.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kaptas.com.roomdb.Interface.MyDAO;
import kaptas.com.roomdb.Model.User;

@Database(entities = User.class, version = 1)
public abstract class MyAppDataBase extends RoomDatabase {

    public abstract MyDAO myDAO();

}