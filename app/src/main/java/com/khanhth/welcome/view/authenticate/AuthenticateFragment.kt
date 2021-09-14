package com.khanhth.welcome.view.authenticate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.khanhth.welcome.R
import com.khanhth.welcome.activity.HomeActivity

class AuthenticateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authenticate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickEvent()
    }

    private fun initClickEvent() {
        requireView().findViewById<View>(R.id.btnLogin)?.setOnClickListener {
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            requireActivity().startActivity(intent)
        }
    }
}