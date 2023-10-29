package kr.ac.wku.pizzaorderapp_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.pizzaorderapp_20231029.databinding.ActivityViewStoreDetailBinding

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewStoreDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_store_detail)
    }
}