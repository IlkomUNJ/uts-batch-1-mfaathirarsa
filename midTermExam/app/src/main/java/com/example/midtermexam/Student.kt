package com.example.midtermexam

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
) {
    companion object {
        val studentList = mutableListOf<Student>()
    }
}
