//package com.example.practiceapplication
//
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.fragment.findNavController
//
//class SplashFragment : Fragment() {
//        override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//            Handler(
//                Looper.getMainLooper()).postDelayed(
//                {
//                    val action = SplashFragmentDirections.actionSplashFragmentToMainFragment()
//                    findNavController().navigate(action)
//                },2000
//                )
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_splash, container, false)
//    }
//}