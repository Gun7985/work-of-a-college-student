package kr.ac.wku.librarypractice_20231029

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.librarypractice_20231029.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.imgProfile.setOnClickListener {

            // 이미지 뷰도 클릭 이벤트 지원

            // ViewPhotoActivity 사용
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

        binding.btnCall.setOnClickListener {

            // 전화를 바로 걸기(번호만 연결하는 것이 아닌 신호까지)
            // 바로 걸기(CALL) -> 사용자 요금 사용 : 권한 허가 후 가능
            val myUri = Uri.parse("tel:010-1111-2222")
            val myIntent = Intent( Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }
    }
}