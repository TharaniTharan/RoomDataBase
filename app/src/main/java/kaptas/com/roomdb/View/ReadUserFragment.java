package kaptas.com.roomdb.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import kaptas.com.roomdb.Adapter.NewsListAdapter;
import kaptas.com.roomdb.Model.User;
import kaptas.com.roomdb.R;


/**
 * A simple {@link Fragment} subclass.
 */

public class ReadUserFragment extends Fragment {

    private RecyclerView listdata;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user2, container, false);
        listdata = (RecyclerView) view.findViewById(R.id.listdata);

        ArrayList<User> users = (ArrayList<User>) MainActivity.myAppDataBase.myDAO().getAllUser();

        listdata.setHasFixedSize(true);
        listdata.setLayoutManager(new LinearLayoutManager(getActivity()));

        // reverse the array list
        Collections.reverse(users);


        /*ArrayList<User> joblist1 = users;
        Collections.sort(joblist1, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String Key_Id = String.valueOf(o1.getId());
                String Key_Id1 = String.valueOf(o2.getId());
                return Float.valueOf(Key_Id).compareTo(Float.valueOf(Key_Id1));
            }
        });*/


        NewsListAdapter adapter = new NewsListAdapter(getActivity(), users);
        listdata.setAdapter(adapter);
        listdata.setItemAnimator(new DefaultItemAnimator());
        listdata.setNestedScrollingEnabled(false);
        adapter.notifyDataSetChanged();

       /* String info = "";

        for (User user : users) {

            int ID = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\n" + "ID :" + ID + "\n" + "Name :" + name + "\n" + "Email :" + email;
        }*/

        return view;
    }

}
