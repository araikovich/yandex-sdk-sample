package com.araikovich.yandesx_sdk.ui.restaurant_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.araikovich.sdk_showcase.hide
import com.araikovich.sdk_showcase.show
import com.araikovich.yandesx_sdk.MyApplication
import com.araikovich.yandesx_sdk.databinding.FragmentRestaurantsListBinding
import com.araikovich.yandesx_sdk.ui.base.doOnResult
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem

class RestaurantListFragment : Fragment() {

    private lateinit var binding: FragmentRestaurantsListBinding
    private var adapter: RestaurantListAdapter? = null
    private var viewModel: RestaurantListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        viewModel?.getRestaurants()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        observeRestaurants()
    }

    private fun setupViewModel() {
        viewModel =
            (requireContext().applicationContext as MyApplication).appComponent.factory.create(
                RestaurantListViewModel::class.java
            )
    }

    private fun observeRestaurants() {
        viewModel?.restaurantsLiveData?.observe(viewLifecycleOwner, { result ->
            result.doOnResult(
                onSuccess = { showRestaurantsList(result.data.orEmpty()) },
                onError = { _, _ -> showRestaurantsError() },
                onLoading = { showProgressState() }
            )
        })
    }

    private fun showRestaurantsError() {
        Toast.makeText(context, "Some server error", Toast.LENGTH_SHORT).show()
    }

    private fun showRestaurantsList(newItems: List<RestaurantViewItem>) {
        binding.progress.hide()
        binding.rvRestaurants.show()
        adapter?.update(newItems)
    }

    private fun showProgressState() {
        binding.rvRestaurants.hide()
        binding.progress.show()
    }

    private fun setupList() {
        adapter = RestaurantListAdapter()
        binding.rvRestaurants.adapter = adapter
        binding.rvRestaurants.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvRestaurants.addItemDecoration(RestaurantItemsDecorator())
    }
}