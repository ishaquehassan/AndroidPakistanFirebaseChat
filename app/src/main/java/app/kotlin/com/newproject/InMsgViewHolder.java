package app.kotlin.com.newproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DELL on 3/17/2018.
 */

public class InMsgViewHolder extends RecyclerView.ViewHolder {

    TextView unameText;
    TextView msgText;

    public InMsgViewHolder(@NonNull View itemView) {
        super(itemView);
        unameText = itemView.findViewById(R.id.unameText);
        msgText = itemView.findViewById(R.id.msgText);
    }

    public void bind(Message message){
        unameText.setText(message.getUname());
        msgText.setText(message.getMsg());
    }
}
