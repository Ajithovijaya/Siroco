package ajith_siroco.app.com.siroco.Dashboard_Frag;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.AdapterswithHolder.ChatAdapter;
import ajith_siroco.app.com.siroco.DataBase.DataEntity;
import ajith_siroco.app.com.siroco.DataBase.DataViewModal;
import ajith_siroco.app.com.siroco.R;


public class Message_Fragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView_msg;
    DataViewModal dataViewModal;
    ImageView btn_send;
    EditText editText;
    String msg,date,time;
    DataEntity dataEntity;
    public Message_Fragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_message,container,false);
        toolbar=(Toolbar)view.findViewById(R.id.tool_message);
        ((DashBoardActivity) getActivity()).setSupportActionBar(toolbar);
        ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("Messaging");
        ((DashBoardActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
        return view;
    }





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        toolbar=(Toolbar)view.findViewById(R.id.tool_message);
        recyclerView_msg=(RecyclerView)view.findViewById(R.id.chat_container);
        btn_send=(ImageView)view.findViewById(R.id.btn_senmsg);
        editText=(EditText)view.findViewById(R.id.txt_sendmsg);
        recyclerView_msg.setHasFixedSize(false);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView_msg.setLayoutManager(linearLayoutManager);
        final ChatAdapter chatAdapter=new ChatAdapter(getContext());
        recyclerView_msg.setAdapter(chatAdapter);
        dataViewModal= ViewModelProviders.of(this).get(DataViewModal.class);

        dataViewModal.getAllData().observe(this, new Observer<List<DataEntity>>() {

            @Override
            public void onChanged(@Nullable List<DataEntity> dataEntities) {
                chatAdapter.setDataEntityList(dataEntities);
                int i=recyclerView_msg.getAdapter().getItemCount();
                recyclerView_msg.scrollToPosition(i-1);
            }
        });


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataEntity=new DataEntity();
                msg=editText.getText().toString();

                SimpleDateFormat formatter
                        = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss a zzz");
                Date currentTime_1 = new Date();
                String dateString = formatter.format(currentTime_1);
                String[] arr=dateString.split(" ");

                time=arr[3]+arr[4];
                date=arr[0];

                dataEntity.setMessage(msg);
                dataEntity.setType(false);
                dataEntity.setTime(time);
                dataEntity.setDay(date);
                dataViewModal.insert(dataEntity);
                editText.setText("");

            }
        });


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.message_menu,menu);


    }
}
