package com.pipsqueak.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pipsqueak.R
import com.pipsqueak.databinding.FragmentMainBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class MainFragment : Fragment(), KodeinAware {

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val factory : MainFragmentViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container,false)
        val viewModel = ViewModelProviders.of(this,factory).get(MainFragmentViewModel::class.java)

        viewModel.getLocationByIPFromAPIandSaveToDB()

        //binding view model from the fragment xml code in <com.pipsqueak.data>
      //  binding. = viewModel

        return binding.root

    }
}