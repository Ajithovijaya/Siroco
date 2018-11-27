package ajith_siroco.app.com.siroco.AdapterswithHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ajith_siroco.app.com.siroco.DataBase.DataEntity;
import ajith_siroco.app.com.siroco.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatHolder> {



    List<DataEntity> dataTableEntityList;
    Context context;
    public void setDataEntityList( List<DataEntity> dataMaodelList) {
        this.dataTableEntityList=dataMaodelList;
        notifyItemInserted(dataTableEntityList.size()-1);

//        notifyDataSetChanged();
//        notifyItemChanged(0,dataMaodelList.size()-1);


    }
    public ChatAdapter(Context applicationContext) {
        this.context=applicationContext;

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }



    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {

        DataEntity dataTableEntity=dataTableEntityList.get(position);

        if (position>0) {
            if (!dataTableEntity.getDay().equals(dataTableEntityList.get(position - 1).getDay())) {
                holder.date.setText(dataTableEntity.getDay());
                holder.date.setVisibility(View.VISIBLE);
            }else {
                holder.date.setVisibility(View.GONE);
            }

        }else if (position==0) {

            holder.date.setText(dataTableEntity.getDay());
            holder.date.setVisibility(View.VISIBLE);
        }




        if (dataTableEntity.getType())
        {
            holder.rec_msg.setText(dataTableEntity.getMessage());
            holder.rec_tim.setText(dataTableEntity.getTime());
            holder.item_rec.setVisibility(View.VISIBLE);
            holder.item_sen.setVisibility(View.GONE);
        }else {
            holder.sen_msg.setText(dataTableEntity.getMessage());
            holder.sen_tim.setText(dataTableEntity.getTime());
            holder.item_sen.setVisibility(View.VISIBLE);
            holder.item_rec.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        if (dataTableEntityList!=null) {
            return dataTableEntityList.size();
        }
        else {
            return 0;
        }
    }
}
