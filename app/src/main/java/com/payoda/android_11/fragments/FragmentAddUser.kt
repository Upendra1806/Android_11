package com.payoda.android_11.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.payoda.android_11.MainActivity
import com.payoda.android_11.R
import com.payoda.android_11.entity.User
import com.payoda.android_11.viewmodels.ViewModelAddUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAddUser : Fragment() {

    private lateinit var mView: View


    companion object {
        fun newInstance() = FragmentAddUser()
    }

    private val viewModel: ViewModelAddUser by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.window_inset_fragment, container, false);
        return mView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mView.findViewById<AppCompatButton>(R.id.btnNext).setOnClickListener {
            var user = User(
                mView.findViewById<AppCompatEditText>(R.id.etMobile).editableText.toString(),
                mView.findViewById<AppCompatEditText>(R.id.etName).editableText.toString(),
                mView.findViewById<AppCompatEditText>(R.id.etEmail).editableText.toString(),
                mView.findViewById<AppCompatEditText>(R.id.etMobile).editableText.toString(),
                mView.findViewById<AppCompatEditText>(R.id.etAddress).editableText.toString()
            )
            if (!TextUtils.isEmpty(user.mobile))
                viewModel.insert(user)

            (activity as MainActivity).replaceFragment(
                FragmentUserList.newInstance(),
                "Fragment two"
            )

        }
    }


}