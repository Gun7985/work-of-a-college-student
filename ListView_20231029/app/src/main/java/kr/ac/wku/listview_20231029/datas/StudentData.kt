package kr.ac.wku.listview_20231029.datas

import android.util.Log

class StudentData( // StudentData의 생성자 변경 : 이름, 출생년도, 폰번호를 넣어서 생성하게함.
    val name:String,
    val birthYear: Int,
    val phoneNum:String) {

// 생성자 문법 체험 -> 폰번호를 안받는 생성자도 쓰고 싶다. Main : 전부 다 받는. Sub : 폰번은 안받는 (보조)

    constructor( name: String, birthYear: Int) : this(name, birthYear, "폰번 모름")

//    현재 한국식 나이를 계산해서 리턴해주는 함수

    fun getKoreanAge( year: Int ) : Int{

        return year - this.birthYear +1

    }

//    void 대체 연습 : 폰번을 - 제외하고 주는 함수

    fun  getSimplePhoneNum(){//리턴타입 명시 X : 리턴 없다(Java의 void)

        Log.d("학생데이터",this.phoneNum.replace("-",""))
    }

}