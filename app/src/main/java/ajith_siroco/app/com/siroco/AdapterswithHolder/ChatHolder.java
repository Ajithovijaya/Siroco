package ajith_siroco.app.com.siroco.AdapterswithHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ajith_siroco.app.com.siroco.R;

public class ChatHolder extends RecyclerView.ViewHolder {
    TextView rec_msg,sen_msg,rec_tim,sen_tim,date;
    CardView item_rec,item_sen;

    public ChatHolder(View itemView) {
        super(itemView);
        rec_msg=(TextView)itemView.findViewById(R.id.itm_msg_rec);
        rec_tim=(TextView)itemView.findViewById(R.id.item_time_rec);
        sen_msg=(TextView)itemView.findViewById(R.id.item_msg_send);
        sen_tim=(TextView)itemView.findViewById(R.id.item_time_send);
        item_rec=(CardView)itemView.findViewById(R.id.item_recieve);
        item_sen=(CardView)itemView.findViewById(R.id.item_send);
        date=(TextView)itemView.findViewById(R.id.chatdate);

    }
}
