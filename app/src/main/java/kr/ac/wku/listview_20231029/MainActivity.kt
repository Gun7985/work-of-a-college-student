package kr.ac.wku.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.listview_20231029.adapters.StudentAdapter
import kr.ac.wku.listview_20231029.databinding.ActivityMainBinding
import kr.ac.wku.listview_20231029.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    lateinit var mStdAdapter: StudentAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        화면이 켜질때, 학생 목록을 ArrayList에 수기로 추가 (임시황룔) -> 실무에서는 서버를 통해 DB가져옴

        mStudentList.add( StudentData("김일일",1998,"010-1111-1111"))
        mStudentList.add( StudentData("김이이",1999,"010-2222-2222"))
        mStudentList.add( StudentData("김삼삼",2000,"010-3333-0000"))
        mStudentList.add( StudentData("김사사",2001,"010-0000-0000"))
        mStudentList.add( StudentData("김오오",2002,"010-0000-0000"))
        mStudentList.add( StudentData("박육육",2003))

//        어댑터 변수도 객체 생성
        mStdAdapter = StudentAdapter( this, R.layout.student_list_item, mStudentList)

//        만들어진 어댑터를 리스트뷰의 어댑터로 연결
        binding.studentListView.adapter = mStdAdapter
    }
}