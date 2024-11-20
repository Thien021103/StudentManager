package com.example.studentmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val students: MutableList<Student>,
    private val onEdit: (Int) -> Unit, // Callback khi nhấn nút Edit
    private val onDelete: (Int) -> Unit // Callback khi nhấn nút Delete
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textStudentName: TextView = itemView.findViewById(R.id.text_student_name)
        val textStudentId: TextView = itemView.findViewById(R.id.text_student_id)
        val imgEdit: ImageView = itemView.findViewById(R.id.image_edit)
        val imgDelete: ImageView = itemView.findViewById(R.id.image_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_student_item, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]

        holder.textStudentName.text = student.studentName
        holder.textStudentId.text = student.studentId

        // Xử lý sự kiện khi nhấn nút Edit
        holder.imgEdit.setOnClickListener {
            onEdit(position)
        }

        // Xử lý sự kiện khi nhấn nút Remove
        holder.imgDelete.setOnClickListener {
            onDelete(position)
        }
    }
}