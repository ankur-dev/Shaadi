package com.shaadi.assigenment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.shaadi.assigenment.R
import com.shaadi.assigenment.base.BaseFragment
import com.shaadi.assigenment.databinding.FragmentMatchCardListBinding
import com.shaadi.assigenment.ui.adapter.ShaadiMatchCardListAdapter
import com.shaadi.assigenment.ui.viewModel.MatchCardViewModel
import com.shaadi.assigenment.util.Resource
import org.koin.android.ext.android.inject


/**
 * A simple [Fragment] subclass.
 * Use the [MatchCardListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MatchCardListFragment : BaseFragment() {
    private lateinit var mBinding: FragmentMatchCardListBinding
    private val mViewModel: MatchCardViewModel by inject()
    private lateinit var mAdapter: ShaadiMatchCardListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_match_card_list, container, false)


        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.isLoading = false
        setupRecyclerView()
        setupObservers()
    }


    private fun setupObservers() {
        mViewModel.resultsItem.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    mBinding.isLoading = false
                    if (!it.data.isNullOrEmpty()) mAdapter.updateData(ArrayList(it.data))
                }
                Resource.Status.ERROR -> {
                    mBinding.isLoading = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                Resource.Status.LOADING ->
                    mBinding.isLoading = true
            }
        })
    }

    private fun setupRecyclerView() {
        mAdapter = ShaadiMatchCardListAdapter(mViewModel)
        mBinding.rvMatchCardList.adapter = mAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MatchCardListFragment().apply {
            }
    }

}