package kaptas.com.roomdb.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import kaptas.com.roomdb.Model.User;
import kaptas.com.roomdb.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class AddUserFragment extends Fragment {

    private EditText userid, username, useremail;
    private Button submit;


    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        useremail = (EditText) view.findViewById(R.id.user_email);
        userid = (EditText) view.findViewById(R.id.user_id);
        username = (EditText) view.findViewById(R.id.user_name);
        submit = (Button) view.findViewById(R.id.submit);

        /*ArrayList<User> users = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getAllUser();
        if (users.size() == 0) {
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setId(i);
                user.setEmail("abc@gmail.com");
                user.setName("Tharani");
                MainActivity.myAppDataBase.myDAO().addUser(user);
            }
        } else {
            Log.e("", "");
        }
        */

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userid.getText().toString().length() != 0) {
                    int ID = Integer.parseInt(userid.getText().toString());
                    String mUsername = username.getText().toString().trim();
                    String mUserEmail = useremail.getText().toString().trim();
                    ArrayList<User> user_id_exist = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getUser_id(ID);
                    // Check weather the user is present in DB already
                    if (user_id_exist.size() == 0) {
                        // If the user tabel is more that five .delete the last row
                        ArrayList<User> total_user_id = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getAllUser();
                        // 4 > reference to only 5 rows can be added
                        if (total_user_id.size() > 4) {
                            // Delete the first row of the DB
                            MainActivity.myAppDataBase.myDAO().deleteRow_id(total_user_id.get(0).getId());
                        }
                        // New user Added
                        User user = new User();
                        user.setId(ID);
                        user.setEmail(mUserEmail);
                        user.setName(mUsername);
                        // User Added
                        MainActivity.myAppDataBase.myDAO().addUser(user);
                        Toast.makeText(getActivity(), "ADDED", Toast.LENGTH_LONG).show();
                        userid.setText("");
                        useremail.setText("");
                        username.setText("");
                    } else {
                        Toast.makeText(getActivity(), "Already UserID is there", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Kindly Enter your ID", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}