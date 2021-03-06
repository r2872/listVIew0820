package com.example.listview0820

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listview0820.adapters.StudentAdapter
import com.example.listview0820.data.StudentData
import com.example.listview0820.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mStudentList = ArrayList<StudentData>()

    private lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mStudentList.add(StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("권유진", 1996, "서울시 강남구"))
        mStudentList.add(StudentData("김경윤", 1997, "서울시 파주시"))
        mStudentList.add(StudentData("김현우", 1996, "서울시 마포구"))
        mStudentList.add(StudentData("김현지", 1995, "서울시 은평구"))
        mStudentList.add(StudentData("김희섭", 1989, "서울시 관악구"))
        mStudentList.add(StudentData("송병섭", 1989, "서울시 광진구"))
        mStudentList.add(StudentData("안수지", 1989, "서울시 동대문구"))
        mStudentList.add(StudentData("유병재", 1995, "경기도 부천시"))
        mStudentList.add(StudentData("이재환", 1997, "경기도 남양주시"))
        mStudentList.add(StudentData("이준서", 2000, "경기도 의왕시"))
        mStudentList.add(StudentData("장혜린", 1995, "인천시 남동구"))

        mAdapter = StudentAdapter(this@MainActivity, R.layout.student_item, mStudentList)

        binding.studentListView.adapter = mAdapter

        binding.studentListView.setOnItemClickListener { _, _, position, _ ->
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

        binding.studentListView.setOnItemLongClickListener { parent, view, position, id ->
            val student = mStudentList[position]

            Toast.makeText(this, "${student.name} 길게 눌림", Toast.LENGTH_SHORT).show()

            return@setOnItemLongClickListener true
        }
    }
}