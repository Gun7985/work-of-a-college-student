package kr.ac.wku.listview_20231029.datas

class StudentData( // StudentData의 생성자 변경 : 이름, 출생년도, 폰번호를 넣어서 생성하게함.
    val name:String,
    val birthYear: Int,
    val phoneNum:String) {

// 생성자 문법 체험 -> 폰번호를 안받는 생성자도 쓰고 싶다. Main : 전부 다 받는. Sub : 폰번은 안받는 (보조)

    constructor( name: String, birthYear: Int) : this(name, birthYear, "폰번 모름")

}