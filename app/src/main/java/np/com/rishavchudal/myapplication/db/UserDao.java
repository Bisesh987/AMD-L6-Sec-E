package np.com.rishavchudal.myapplication.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Created by Rishav Chudal on 30/11/2022.
 */
@Dao
public interface UserDao {
    @Insert
    public void insertUser(User user);

    @Query("SELECT * from user")
    public List<User> getUsers();

    @Query("SELECT * from user WHERE email = :email LIMIT 1")
    public User getUserByEmail(String email);
}
