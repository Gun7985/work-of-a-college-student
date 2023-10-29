package kr.ac.wku.listview_20231029.adapters

import android.content.Context
import android.widget.ArrayAdapter
import kr.ac.wku.listview_20231029.datas.StudentData

class StudentAdapter(
    mContext: Context,
    resId: Int,
    mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList){// ArrayAdapter : 기본 생성자 지원 X
}