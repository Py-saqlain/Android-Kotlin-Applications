package com.example.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDetails: TextView = itemView.findViewById(R.id.tvEmail) // Using tvEmail ID for CGPA and Roll
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.name
        
        // Showing CGPA followed by Roll Number in the list
        holder.tvDetails.text = String.format(Locale.US, "CGPA: %.2f | Roll: %d", student.CGPA, student.RollNumber)

        holder.itemView.setOnClickListener {
            // Showing in Toast
            Toast.makeText(
                holder.itemView.context,
                "Name: ${student.name}\nCGPA: ${student.CGPA}\nRoll Number: ${student.RollNumber}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}