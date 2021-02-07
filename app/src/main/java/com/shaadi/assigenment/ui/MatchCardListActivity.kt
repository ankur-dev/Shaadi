package com.shaadi.assigenment.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shaadi.assigenment.R
import com.shaadi.assigenment.databinding.ActivityMatchCardListBinding
import com.shaadi.assigenment.ui.fragments.MatchCardListFragment
import com.shaadi.assigenment.util.Task

class MatchCardListActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMatchCardListBinding
    private lateinit var mToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_match_card_list)

        setupToolbar()

        openFragment(Task.ARTICLE_LIST_FRAGMENT)

        hideToolbar()
    }

    private fun setupToolbar() {
        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
    }


    private fun openFragment(id: Task) {
        lateinit var fragment: Fragment
        if (id == Task.ARTICLE_LIST_FRAGMENT) {
            fragment = MatchCardListFragment.newInstance()
        }
        try {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(id.name).replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }


    private fun showToolbar() {
        mToolbar.visibility = View.VISIBLE
    }

    private fun hideToolbar() {
        mToolbar.visibility = View.GONE
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
            showToolbar()
        } else {
            finish()
        }

    }

}