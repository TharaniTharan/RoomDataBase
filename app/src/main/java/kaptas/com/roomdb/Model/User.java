package kaptas.com.roomdb.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Tharanitharan")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int dummyID;

    //@PrimaryKey
    @ColumnInfo(name = "User_id")
    private int id;

    @ColumnInfo(name = "User_Name")
    private String name;

    @ColumnInfo(name = "User_Email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}