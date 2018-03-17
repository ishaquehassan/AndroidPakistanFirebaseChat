package app.kotlin.com.newproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by DELL on 3/17/2018.
 */

public class MsgsAdapter extends RecyclerView.Adapter {
    ArrayList<Message> mMessages;
    private static final int IN_MSG = 1;
    private static final int OUT_MSG = 2;

    public MsgsAdapter(ArrayList<Message> mMessages){
        this.mMessages = mMessages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == IN_MSG){
            return new InMsgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.in_msg,parent,false));
        }else{
            return new OutMsgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.out_msg,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message msg = mMessages.get(position);
        if(holder.getItemViewType() == IN_MSG){
            ((InMsgViewHolder)holder).bind(msg);
        }else{
            ((OutMsgViewHolder)holder).bind(msg);
        }
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = mMessages.get(position);
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        return (uid.equals(msg.getUid()) ? OUT_MSG : IN_MSG);
    }
}
