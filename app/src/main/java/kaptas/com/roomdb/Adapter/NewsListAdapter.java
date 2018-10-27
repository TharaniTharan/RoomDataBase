package kaptas.com.roomdb.Adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kaptas.com.roomdb.Model.User;
import kaptas.com.roomdb.R;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private final FragmentActivity mContext;
    private final ArrayList<User> mData;

    public NewsListAdapter(FragmentActivity activity, ArrayList<User> users) {
        this.mContext = activity;
        this.mData = users;
    }

    @NonNull
    @Override
    public NewsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newslistadapter, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NewsListAdapter.ViewHolder holder, int position) {
        holder.userid.setText(mData.get(position).getId() + "");
        holder.username.setText(mData.get(position).getName());
        holder.useremail.setText(mData.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userid, username, useremail;

        public ViewHolder(View itemView) {
            super(itemView);
            userid = (TextView) itemView.findViewById(R.id.user_id);
            username = (TextView) itemView.findViewById(R.id.user_name);
            useremail = (TextView) itemView.findViewById(R.id.user_email);
        }
    }
}
