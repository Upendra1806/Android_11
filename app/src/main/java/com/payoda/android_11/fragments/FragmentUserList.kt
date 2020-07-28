package com.payoda.android_11.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.payoda.android_11.R
import com.payoda.android_11.adapters.UserAdapter
import com.payoda.android_11.entity.User
import com.payoda.android_11.viewmodels.ViewModelUserList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentUserList : Fragment() {

    companion object {
        fun newInstance() = FragmentUserList()
    }

    private val userListViewModel: ViewModelUserList by viewModels()
    private lateinit var mView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_user_list_fragment, container, false)
        return mView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userListViewModel.userdata.observe(viewLifecycleOwner, Observer {
            setAdapter(it)

        }
        )
    }

    fun setAdapter(userList: MutableList<User?>?) {

        val recyclerView = mView.findViewById<RecyclerView>(R.id.recycleView)
        val adapter = UserAdapter()
        adapter.updateUserList(userList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged();
    }


}