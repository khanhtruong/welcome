package com.khanhth.welcome.view.authenticate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.khanhth.welcome.R
import com.khanhth.welcome.activity.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticateFragment : Fragment() {

    private val viewModel: AuthenticateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authenticate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initClickEvent()
    }

    private fun initViewModel() {
        viewModel.onSuccess.observe(viewLifecycleOwner, { success ->
            if (success) {
                val intent = Intent(requireActivity(), HomeActivity::class.java)
                requireActivity().startActivity(intent)
            } else {
//                requireView().snackbar("Failed, wrong password!!!")
                Log.d("Debuggg", "Failed, wrong password!!!")
            }
        })
    }

    private fun initClickEvent() {
        requireView().findViewById<View>(R.id.btnLogin)?.setOnClickListener {
            requireView().findViewById<TextView>(R.id.etPass)?.let { tvPass ->
                viewModel.validatePass(tvPass.text.toString())
            }
        }
    }
}