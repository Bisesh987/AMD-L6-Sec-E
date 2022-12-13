package np.com.rishavchudal.myapplication.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Rishav Chudal on 30/11/2022.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
