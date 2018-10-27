package kaptas.com.roomdb.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kaptas.com.roomdb.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button adduser, updateuser, deleteuser, viewuser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adduser = (Button) view.findViewById(R.id.insert);
        updateuser = (Button) view.findViewById(R.id.update);
        deleteuser = (Button) view.findViewById(R.id.delete);
        viewuser = (Button) view.findViewById(R.id.viewuser);

        adduser.setOnClickListener(this);
        updateuser.setOnClickListener(this);
        deleteuser.setOnClickListener(this);
        viewuser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.viewuser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new ReadUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DelectUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new UpdateUserFragment()).addToBackStack(null).commit();
                break;

        }
    }
}
