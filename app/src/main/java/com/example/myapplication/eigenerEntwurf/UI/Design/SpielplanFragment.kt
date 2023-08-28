package com.example.myapplication.eigenerEntwurf.UI.Design

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.eigenerEntwurf.adapter.SpielplanAdapter
import com.example.myapplication.eigenerEntwurf.databinding.SpielplanBinding
import com.example.myapplication.eigenerEntwurf.remote.TAG

class SpielplanFragment : Fragment() {

    private val viewModel: SpielplanViewModel by viewModels()

    private lateinit var binding: SpielplanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.loadTeam()

        binding = SpielplanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewSpielplan.setHasFixedSize(true)

        viewModel.spteam.observe(viewLifecycleOwner) {
            Log.d(TAG, "$it")
            binding.recyclerViewSpielplan.adapter = SpielplanAdapter(it)

            binding.backToTabelleButton.setOnClickListener {
                val navController = findNavController()
                navController.navigate(SpielplanFragmentDirections.actionSpielplanFragmentToTabellenFragment())
            }
        }
    }
}