package com.cagatayipek.feedapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.cagatayipek.feedapp.databinding.FragmentLoginmenuBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class loginmenu : Fragment() {
    private var _binding: FragmentLoginmenuBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginmenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myButton.setOnClickListener {
            var auth= Firebase.auth
            var name =binding.username.text.toString() + "@gmail.com"
            var password=binding.password.text.toString()
            auth.createUserWithEmailAndPassword(name,password)
        }
        binding.myButton2.setOnClickListener {

            if (binding.username.text.isNullOrEmpty()){
                Toast.makeText(context,"Kullanıcı Adı Veya Parola Girmediniz.",Toast.LENGTH_LONG).show()
            }
            else{
                var auth= Firebase.auth
                var name =binding.username.text.toString() + "@gmail.com"
                var password=binding.password.text.toString()
                auth.signInWithEmailAndPassword(name,password)
                var action =loginmenuDirections.actionLoginmenuToPostfeed()
                Navigation.findNavController(view).navigate(action)
            }


        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}