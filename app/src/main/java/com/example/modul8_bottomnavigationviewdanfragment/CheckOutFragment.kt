package com.example.modul8_bottomnavigationviewdanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.modul8_bottomnavigationviewdanfragment.databinding.FragmentCheckOutBinding

class CheckOutFragment : Fragment() {
    private lateinit var binding: FragmentCheckOutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckOutBinding.inflate(inflater, container, false)
        val view = binding.root
        val edt_address = binding.edtAddress
        with(binding) {
            val args: CheckOutFragmentArgs by navArgs()
            edt_address.setText(args.address)
            txtProductName.setText(args.productName)
            findNavController().currentBackStackEntry
                ?.savedStateHandle?.let { handle ->
                    handle.getLiveData<String>("address")
                        .observe(viewLifecycleOwner) { res ->
                            edtAddress.setText(res)
                        }
                }
            edtAddress.setOnClickListener {
                val action =
                    CheckOutFragmentDirections.actionCheckOutFragmentToAddressFragment()
                findNavController().navigate(action)
            }
            return view
        }
    }
}