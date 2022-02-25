package com.agnext.univerialapp.network

data class Employee (
    val status: String,
    val massage: String,
    val employeeDetail: EmployeesDetail
)

data class EmployeesDetail(
    val id: Int,
    val employee_name: String,
    val employee_salary: String,
    val employee_age:Int,
    val profile_image:String
)