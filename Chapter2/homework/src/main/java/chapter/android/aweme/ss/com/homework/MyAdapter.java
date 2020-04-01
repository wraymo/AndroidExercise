package chapter.android.aweme.ss.com.homework;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;


/**
 * 适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Message> message;
    private Context context;

    public MyAdapter(Context context, List<Message> message) {
        this.context = context;
        this.message = message;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder numberViewHolder, int position) {
        numberViewHolder.bind(message.get(position));
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CircleImageView circleImageView;
        private ImageView official;
        private TextView title;
        private TextView description;
        private TextView time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.iv_avatar);
            official = itemView.findViewById(R.id.robot_notice);
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            time = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(Message m) {
            switch (m.getIcon()) {
                case "TYPE_ROBOT":
                    circleImageView.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_GAME":
                    circleImageView.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
                case "TYPE_SYSTEM":
                    circleImageView.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_STRANGER":
                    circleImageView.setImageResource(R.drawable.session_stranger);
                    break;
                case "TYPE_USER":
                    circleImageView.setImageResource(R.drawable.icon_girl);
                    break;
            }
            if(m.isOfficial())
                official.setVisibility(View.VISIBLE);
            else
                official.setVisibility(View.GONE);
            title.setText(m.getTitle());
            description.setText(m.getDescription());
            time.setText(m.getTime());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ChatRoomActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", getLayoutPosition());
            bundle.putString("title", message.get(getLayoutPosition()).getTitle());
            intent.putExtra("data", bundle);
            context.startActivity(intent);
        }
    }
}
