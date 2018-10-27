package kaptas.com.roomdb.View;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class UpdateUserFragment extends Fragment {

    private EditText update_user_id, update_user_name, update_user_email;
    Button update_submit;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);
        update_user_id = (EditText) view.findViewById(R.id.update_user_id);
        update_user_name = (EditText) view.findViewById(R.id.update_user_name);
        update_user_email = (EditText) view.findViewById(R.id.update_user_email);
        update_submit = (Button) view.findViewById(R.id.update_submit);


        update_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (update_user_id.getText().toString().length() != 0) {
                    int USERID = Integer.parseInt(update_user_id.getText().toString().trim());
                    String mUpdateUserName = update_user_name.getText().toString().trim();
                    String mUpdateEmail = update_user_email.getText().toString().trim();

                    /*User user = new User();
                    user.setId(USERID);
                    user.setName(mUpdateUserName);
                    user.setEmail(mUpdateEmail);
                    MainActivity.myAppDataBase.myDAO().update(user);*/

                    ArrayList<User> user_id_exist = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getUser_id(USERID);
                    // Check weather the user is present in DB . If present Update the Row from DB
                    if (user_id_exist.size() != 0) {
                        // Update the user
                        MainActivity.myAppDataBase.myDAO().updateRow_id(USERID,mUpdateUserName,mUpdateEmail);
                        Toast.makeText(getActivity(), "UPDATED", Toast.LENGTH_LONG).show();
                        update_user_id.setText("");
                        update_user_email.setText("");
                        update_user_name.setText("");
                    }else {
                        Toast.makeText(getActivity(), "The ID is invalid", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Kindly Enter your ID", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

}
