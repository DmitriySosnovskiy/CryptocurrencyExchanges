package features.currencylist.presentation.recycler

import android.view.View
import app.R
import app.databinding.ItemCryptocurrencyExchangeBinding
import com.xwray.groupie.viewbinding.BindableItem

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
class CryptocurrencyInfoSectionItem(
    private val itemData: CryptocurrencyInfoSectionItemData
) : BindableItem<ItemCryptocurrencyExchangeBinding>() {

    override fun bind(binding: ItemCryptocurrencyExchangeBinding, position: Int) {
        with(binding) {
            currencyImage.setImageResource(itemData.iconDrawableRes)
            currencyTitle.text = itemData.title
            priceInRubText.text = itemData.priceInRub
            priceInUsdText.text = itemData.priceInUsd
            priceInEurText.text = itemData.priceInEur
            lastUpdateAtText.text = itemData.lastUpdatedAt
        }
    }

    override fun getLayout(): Int = R.layout.item_cryptocurrency_exchange

    override fun initializeViewBinding(view: View): ItemCryptocurrencyExchangeBinding {
        return ItemCryptocurrencyExchangeBinding.bind(view)
    }
}