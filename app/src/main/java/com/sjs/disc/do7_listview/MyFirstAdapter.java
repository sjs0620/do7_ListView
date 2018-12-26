package com.sjs.disc.do7_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter extends BaseAdapter {
    private List<Weather> mData;
    private Map<String, Integer> mWeatherImageMap;

    public MyFirstAdapter(List<Weather> Data) {
        this.mData = Data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음",R.drawable.sunny);
        mWeatherImageMap.put("비",R.drawable.rainy);
        mWeatherImageMap.put("구름",R.drawable.cloudy);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather,parent,false);

            ImageView weaterImage = convertView.findViewById(R.id.weather_image);
            TextView cityText = convertView.findViewById(R.id.city_text);
            TextView tempText = convertView.findViewById(R.id.temp_text);

            holder.weaterImage = weaterImage;
            holder.cityText = cityText;
            holder.tempText = tempText;

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        Weather weather = mData.get(position);
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weaterImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));

        return convertView;
    }

    static  class ViewHolder{
        ImageView weaterImage ;
        TextView cityText ;
        TextView tempText ;
    }
}
