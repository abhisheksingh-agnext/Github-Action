package com.agnext.univerialapp.network.Response
import java.util.*

data class LoginResponse(val access_token:String, val permissions:List<String>,val user :User)
data class User(val user_id:Int,val created_by:Int,val created_on:String,val updated_by:Object, val updated_on: Object,
val is_2fa_required:Object,val user_account_number:String,val user_alternate_contact_number:Object,val contact_number:String,
val email:String,val first_name:String,val last_name:String,val customer_id:Int,val customer_name:String,val customer_type:String,
)