package kr.ac.wku.kotlinbasic_20231028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.ac.wku.kotlinbasic_20231028.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnLog.setOnClickListener {
//            로그 버튼이 클릭되면 실행될 코드 스코프

//            로그 찍어보기
            Log.d("메인화면","로그 버튼이 클릭됨")// debug용 로그(개발자 편의용)
            Log.e("메인화면","e로 로그 띄우기")// error 감지 로그
            Log.wtf("메인화면","wtf로 로그 찍어보기")// What the Fxxx 로그 (이왜진?)
        }

        binding.btnToast.setOnClickListener {
//            토스트 버튼이 클릭되면 -> 토스트 띄우기
            Toast.makeText(this, "토스트 클릭됨", Toast.LENGTH_SHORT).show()
        }
    }
}