package app.kotlin.com.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    RecyclerView messagesList;
    Button btnSend;
    ArrayList<Message> mMessages;
    MsgsAdapter mMsgsAdapter;
    EditText msgEt;
    Button sendBtn;
    DatabaseReference msgsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        msgsRef = FirebaseDatabase.getInstance().getReference().child("messages");

        messagesList = findViewById(R.id.messagesList);
        btnSend = findViewById(R.id.sendBtn);
        mMessages = new ArrayList<>();
        mMsgsAdapter = new MsgsAdapter(mMessages);
        messagesList.setAdapter(mMsgsAdapter);
        messagesList.setLayoutManager(new LinearLayoutManager(this));

        msgEt = findViewById(R.id.msgEt);
        sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg(new Message(FirebaseAuth.getInstance().getCurrentUser().getUid(),FirebaseAuth.getInstance().getCurrentUser().getEmail(),msgEt.getText().toString()));
            }
        });

        msgsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot != null){
                    Message msg = dataSnapshot.getValue(Message.class);
                    mMessages.add(msg);
                    mMsgsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void sendMsg(Message msg){
        msgsRef.push().setValue(msg);
    }


}
