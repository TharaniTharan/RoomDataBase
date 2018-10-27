package kaptas.com.roomdb.View;


import android.os.Bundle;
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
public class DelectUserFragment extends Fragment {


    private EditText delectnumber;
    private Button delect;

    public DelectUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delect_user, container, false);

        delectnumber = (EditText) view.findViewById(R.id.delectnumber);
        delect = (Button) view.findViewById(R.id.delect);

        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delectnumber.getText().toString().length() != 0) {
                    int USERID = Integer.parseInt(delectnumber.getText().toString().trim());

                     /*User user = new User();
                    user.setId(USERID);
                    MainActivity.myAppDataBase.myDAO().delete(user);*/

                    ArrayList<User> user_id_exist = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getUser_id(USERID);
                    // Check weather the user is present in DB . If present Delete the Row from DB
                    if (user_id_exist.size() != 0) {
                        // Delete the user
                        MainActivity.myAppDataBase.myDAO().deleteRow_id(USERID);
                        Toast.makeText(getActivity(), "DELETED", Toast.LENGTH_LONG).show();
                        delectnumber.setText("");
                    } else {
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
