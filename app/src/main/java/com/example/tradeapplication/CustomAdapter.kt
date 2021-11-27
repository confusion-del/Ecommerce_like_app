package com.example.tradeapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var data: ArrayList<Item>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var mTxtName: TextView = row?.findViewById(R.id.mTvName) as TextView
        var mTxtPrice: TextView = row?.findViewById(R.id.mTvPrice) as TextView
        var mTxtDesc: TextView = row?.findViewById(R.id.mTvDesc) as TextView
        var mItemPhoto: ImageView = row?.findViewById(R.id.mImgPic) as ImageView

    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Item = getItem(position) as Item
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtPrice.text = item.price
        viewHolder.mTxtDesc.text = item.desc
        viewHolder.mItemPhoto.setImageResource(item.photo)
        return view as View
    }
    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}