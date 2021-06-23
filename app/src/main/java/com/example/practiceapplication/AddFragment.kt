//package com.example.practiceapplication
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import androidx.databinding.DataBindingUtil
//import androidx.navigation.fragment.findNavController
//import com.example.practiceapplication.databinding.FragmentAddBinding
//
//class AddFragment : Fragment() {
//    private lateinit var button: Button
//    private lateinit var text:EditText
//    private lateinit var binding: FragmentAddBinding
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add, container, false)
//        binding.button.setOnClickListener {
//            val action = AddFragmentDirections.actionAddFragmentToMainFragment().apply {
//                text =
//            }
//            action.setText("jhg")
//            findNavController().navigate(action)
//        }
//        // Inflate the layout for this fragment
//        return binding.root
//    }
//}