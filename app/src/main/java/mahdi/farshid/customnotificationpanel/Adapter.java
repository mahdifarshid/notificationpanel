package mahdi.farshid.customnotificationpanel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by farshid on 6/16/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

    Context context;
    List<Data>mylists;
    public Adapter(Context c,List<Data>list){
        context=c;
        mylists=list;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        public MyHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.icon);
            title= (TextView) itemView.findViewById(R.id.title);
        }

    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).load(mylists.get(position).getImage()).into(holder.imageView);
        holder.title.setText(mylists.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mylists.size();
    }




}
