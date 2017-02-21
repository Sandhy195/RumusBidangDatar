package com.example.sipo.rumusbidangdatar;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by SIPO on 4/24/2016.
 */
public class Adapter extends BaseAdapter {

    Context c;
    ArrayList<Bangun> bangun;

    public Adapter(Context c, ArrayList<Bangun> bangun){
        this.c = c;
        this.bangun = bangun;
    }

    @Override
    public int getCount() {
        return bangun.size();
    }

    @Override
    public Object getItem(int position) {
        return bangun.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemview,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewBangun);
        TextView textView = (TextView) convertView.findViewById(R.id.textNamaBangun);

        imageView.setImageResource(bangun.get(position).getGmbrBangun());
        textView.setText(bangun.get(position).getNamaBangun());

        return convertView;
    }
}
