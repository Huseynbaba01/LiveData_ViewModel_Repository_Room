//package com.example.practiceapplication
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.cardview.widget.CardView
//import androidx.databinding.DataBindingUtil
//import androidx.navigation.fragment.findNavController
//import com.example.practiceapplication.databinding.FragmentMainBinding
//
//class MainFragment : Fragment() {
//    private lateinit var button: CardView
//    private lateinit var binding: FragmentMainBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container,false)
////        button = view.findViewById(R.id.button)
//        binding.button.setOnClickListener {
//            val action = MainFragmentDirections.actionMainFragmentToAddFragment()
//            findNavController().navigate(action)
//        }
//        // Inflate the layout for this fragment
//        return binding.root
//    }
//}