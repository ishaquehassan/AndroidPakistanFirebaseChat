package app.kotlin.com.newproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DELL on 3/17/2018.
 */

public class OutMsgViewHolder extends RecyclerView.ViewHolder {

    TextView msgText;

    public OutMsgViewHolder(@NonNull View itemView) {
        super(itemView);
       msgText = itemView.findViewById(R.id.msgText);
    }

    public void bind(Message message){
        msgText.setText(message.getMsg());
    }
}
