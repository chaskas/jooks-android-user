package me.jooks.user.android;

import java.util.ArrayList;
import java.util.List;
import me.jooks.user.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ImageAdapter extends BaseAdapter {
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;

    public ImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);

        items.add(new Item("Copi Copi",       R.drawable.sample_0));
        items.add(new Item("Tepo Tepo",   R.drawable.sample_1));
        items.add(new Item("Cortachurro", R.drawable.sample_2));
        items.add(new Item("James Bond",      R.drawable.sample_3));
        items.add(new Item("Rucia",     R.drawable.sample_4));
        items.add(new Item("Cabeza de Chaya",      R.drawable.sample_5));
        items.add(new Item("Fierro Malo",      R.drawable.sample_6));
        items.add(new Item("Yo no fui",      R.drawable.sample_7));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null) {
            v = inflater.inflate(R.layout.item_places, viewGroup, false);
            v.setTag(R.id.logoPlace, v.findViewById(R.id.logoPlace));
            v.setTag(R.id.textPlace, v.findViewById(R.id.textPlace));
        }

        picture = (ImageView)v.getTag(R.id.logoPlace);
        name = (TextView)v.getTag(R.id.textPlace);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        //picture.setPadding(2, 2, 2, 2);
        name.setText(item.name);
        //name.setPadding(2, 2, 2, 2);

        return v;
    }

    private class Item {
        final String name;
        final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
    
}