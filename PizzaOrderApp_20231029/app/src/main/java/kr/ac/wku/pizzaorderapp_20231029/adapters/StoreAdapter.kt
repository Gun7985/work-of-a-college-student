package kr.ac.wku.pizzaorderapp_20231029.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.ac.wku.pizzaorderapp_20231029.R
import kr.ac.wku.pizzaorderapp_20231029.datas.StoreData

class StoreAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StoreData>) :ArrayAdapter<StoreData>(mContext, resId, mList) {

        val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null){

            tempRow = inf.inflate(R.layout.pizza_store_list_item, null)
        }

        val row = tempRow!!

        val data = mList[position]

        val imgLogo = row.findViewById<ImageView>( R.id.imgLogo)
        val txtStoreName = row.findViewById<TextView>( R.id.txtStoreNmae)

        txtStoreName.text = data.name

        Glide.with(mContext).load(data.logoURL).into(imgLogo)

        return row

    }
}