package com.payoda.android_11.entity


data class Employee(var name:String,var emailId:String,var mobile:String,var empId:String, var address:Address) {

    data class Address(var house:String,var town: String,var pincode:String, var state:String)
}