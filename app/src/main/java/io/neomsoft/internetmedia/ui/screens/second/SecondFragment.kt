package io.neomsoft.internetmedia.ui.screens.second

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import io.neomsoft.internetmedia.R
import io.neomsoft.internetmedia.databinding.FragmentSecondBinding
import io.neomsoft.internetmedia.ui.base.BaseFragment

class SecondFragment : BaseFragment(R.layout.fragment_second) {

    private val binding: FragmentSecondBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}