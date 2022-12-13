package np.com.rishavchudal.myapplication.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Rishav Chudal on 30/11/2022.
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public String password;
}
