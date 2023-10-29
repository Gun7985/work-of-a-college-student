package kr.ac.wku.activity_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.activity_20231029.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_third)

//        3번 화면이 열리면 -> 이전 화면에서 보내준 String을 받아서 txtMessage에 반영
//        이전 화면에서 보내준 "message"라는 이름표가 붙어있는 String 추출
        val receivedMessage = intent.getStringExtra("message")

        binding.txtMessage.text = receivedMessage
    }
}