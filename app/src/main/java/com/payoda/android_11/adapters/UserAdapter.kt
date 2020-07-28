package com.payoda.android_11.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.payoda.android_11.R
import com.payoda.android_11.entity.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var userList: MutableList<User?>? = null

    fun updateUserList(userList: MutableList<User?>?) {
        this.userList = userList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false);
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvName.setText(userList!!.get(position)!!.name)
        holder.tvPhone.setText(userList!!.get(position)!!.mobile)


    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivIcon = itemView.findViewById<AppCompatImageView>(R.id.icUser)
        var tvName = itemView.findViewById<AppCompatTextView>(R.id.tvName);
        var tvPhone = itemView.findViewById<AppCompatTextView>(R.id.tvPhone);


    }

}