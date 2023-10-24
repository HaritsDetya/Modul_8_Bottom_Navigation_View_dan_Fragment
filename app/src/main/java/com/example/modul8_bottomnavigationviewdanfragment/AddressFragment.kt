package com.example.modul8_bottomnavigationviewdanfragment

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.modul8_bottomnavigationviewdanfragment.databinding.FragmentAddressBinding

class AddressFragment : Fragment() {
    private lateinit var binding: FragmentAddressBinding
    private lateinit var provinces: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding){
            provinces = resources.getStringArray(R.array.provinces)
            val adapterProvinces = ArrayAdapter(requireContext(),
                R.layout.simple_spinner_item, provinces)
            adapterProvinces.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinnerProvinces.adapter = adapterProvinces
            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry
                        ?.savedStateHandle?.set("address",
                            spinnerProvinces.selectedItem.toString())
                }.navigateUp()
            }
        }
        return view
    }
}