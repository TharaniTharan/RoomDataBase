package kaptas.com.roomdb.Interface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import kaptas.com.roomdb.Model.User;

@Dao
public interface MyDAO {

    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM Tharanitharan")
    List<User> getAllUser();

    @Update
    public void update(User user);

    @Delete
    public void delete(User user);

    // Check Weather the user ID is already is present in DB or not
    @Query("SELECT * FROM Tharanitharan where User_id = (:my_id)")
    List<User> getUser_id(int my_id);

    // Delete the row using the ID
    @Query("DELETE FROM Tharanitharan where User_id = (:my_id)")
    public void deleteRow_id(int my_id);

    // Update the modal using ID
    @Query("update Tharanitharan set User_Name=:userName, User_Email=:EmailID where User_id = (:my_id)")
    long updateRow_id(int my_id, String userName, String EmailID);


}