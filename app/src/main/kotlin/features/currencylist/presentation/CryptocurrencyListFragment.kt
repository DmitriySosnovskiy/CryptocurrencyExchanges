package features.currencylist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.R
import app.databinding.FragmentCryptocurrencyListBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import common.di.base.FeaturesContainer
import common.presentation.base.BaseFragment
import common.utils.ext.dpToPx
import dev.chrisbanes.insetter.applyInsetter
import features.currencylist.di.CryptocurrencyListFeatureApi
import features.currencylist.presentation.recycler.CryptocurrencyInfoSectionItem
import features.currencylist.presentation.recycler.CryptocurrencyInfoSectionItemData
import features.currencylist.presentation.recycler.VerticalMarginItemDecoration

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 26.04.2023
 */
class CryptocurrencyListFragment : BaseFragment(R.layout.fragment_cryptocurrency_list) {

    private lateinit var viewModel: CryptocurrencyListViewModel

    private val binding by viewBinding(FragmentCryptocurrencyListBinding::bind)

    private val cryptocurrencyListSection = Section()

    override fun getDependencies(featuresContainer: FeaturesContainer) {
        viewModel = ViewModelProvider(
            this,
            featuresContainer.getFeature(CryptocurrencyListFeatureApi::class.java)
                .cryptocurrencyListViewModelProviderFactory
        ).get(CryptocurrencyListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCryptocurrencyListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        viewModel.state.observe(viewLifecycleOwner) {
            handleState(it)
        }
    }

    private fun initViews() {
        binding.root.applyInsetter {
            type(statusBars = true, navigationBars = true) { padding() }
        }

        with(binding.cryptocurrencyRecycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = GroupAdapter<GroupieViewHolder>().apply {
                add(cryptocurrencyListSection)
            }
            addItemDecoration(VerticalMarginItemDecoration(16.dpToPx()))
        }

        binding.refresh.setOnRefreshListener { viewModel.loadData() }
    }

    private fun handleState(state: CryptocurrencyListViewState) {
        refresh(state = state)

        when (state) {
            is CryptocurrencyListViewState.Loading -> state.handle()
            is CryptocurrencyListViewState.Content -> state.handle()
            is CryptocurrencyListViewState.Error -> state.handle()
        }
    }

    private fun refresh(state: CryptocurrencyListViewState) {
        binding.refresh.isRefreshing = false

        binding.progressLottie.isVisible = state is CryptocurrencyListViewState.Loading
        binding.errorLayout.root.isVisible = state is CryptocurrencyListViewState.Error
    }

    private fun CryptocurrencyListViewState.Loading.handle() {
        cryptocurrencyListSection.clear()
        binding.progressLottie.playAnimation()
    }

    private fun CryptocurrencyListViewState.Content.handle() {
        val sectionItems = sectionItemsData.mapNotNull {
            if (it is CryptocurrencyInfoSectionItemData) CryptocurrencyInfoSectionItem(
                itemData = it
            ) else null
        }

        cryptocurrencyListSection.update(sectionItems)
    }

    private fun CryptocurrencyListViewState.Error.handle() {
        binding.errorLayout.retryButton.setOnClickListener {
            viewModel.loadData()
        }
    }
}