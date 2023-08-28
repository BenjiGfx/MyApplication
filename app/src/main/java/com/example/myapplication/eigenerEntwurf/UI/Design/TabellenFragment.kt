package com.example.myapplication.eigenerEntwurf.UI.Design

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.eigenerEntwurf.adapter.TabellenAdapter
import com.example.myapplication.eigenerEntwurf.databinding.FragmentTabelleSpielplanBinding
import com.example.myapplication.eigenerEntwurf.databinding.ListItemTabelleBinding
import com.example.myapplication.eigenerEntwurf.remote.TAG

class TabellenFragment : Fragment() {

    private val viewModel: TabellenViewModel by viewModels()

    private lateinit var binding: FragmentTabelleSpielplanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.loadTeam()

        binding = FragmentTabelleSpielplanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewTabelle.setHasFixedSize(true)

        viewModel.team.observe(viewLifecycleOwner) {
            Log.d(TAG,"$it")
            binding.recyclerviewTabelle.adapter = TabellenAdapter(it)

            binding.buttonSpielplan.setOnClickListener {
                val navController = findNavController()
                navController.navigate(TabellenFragmentDirections.actionTabellenFragmentToSpielplanFragment())
            }
        }
    }
}