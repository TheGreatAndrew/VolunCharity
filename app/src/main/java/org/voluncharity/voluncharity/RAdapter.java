package org.voluncharity.voluncharity;

import android.content.Context;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
//import com.squareup.picasso:picasso:2.8;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class RAdapter extends RecyclerView.Adapter<RAdapter.viewSpot> {
    private ArrayList<AndroidVersion> android;
    private Context context;

    public RAdapter(Context context, ArrayList<AndroidVersion> android){
        this.android = android;
        this.context = context;
    }

    @Override
    public int getItemCount(){
        return android.size();
    }

    @Override
    public RAdapter.viewSpot onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new viewSpot(v);
    }

    @Override
    public void onBindViewHolder(RAdapter.viewSpot vs, int i){
        vs.texts.setText(android.get(i).getVersionName());
        //No using context
       int drwId = this.context.getResources().getIdentifier(android.get(i).getImageURL(),"drawable",context.getPackageName());
       vs.img.setImageResource(drwId);
    }


    public class viewSpot extends RecyclerView.ViewHolder{
        private TextView texts;
        private ImageView img;

        public viewSpot(View view){
            super(view);
            texts = (TextView)view.findViewById(R.id.text_view);
            img = (ImageView) view.findViewById(R.id.img_view);
        }
    }
}
