package com.example.listview0820.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview0820.R
import com.example.listview0820.data.StudentData

class StudentAdapter(
    private val mContext: Context,
    private val resId: Int,
    private val mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList) {

    private val mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.student_item, null)
        }

        val row = tempRow!!

        // row 가 결과로 (화면에) 나가기 전에 -> 추가 가공을 거치고 나가게 하자.

        // mList 의 학생 중 위치에 맞는 데이터를 뽑아서 -> row 내부의 텍스트뷰에 문구로 반영하자

        val data = mList[position]

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)

        nameTxt.text = data.name
        addressTxt.text = data.address
        ageTxt.text = "(${2021 - data.birthYear + 1}세)"

        return row
    }
}