package features.currencylist.domain.models

import app.R

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
enum class Cryptocurrency(
    val id: String,
    val nameRes: Int,
    val iconRes: Int
) {
    BITCOIN(id = "bitcoin", nameRes = R.string.bitcoin_cryptocurrency_name, iconRes = R.drawable.ic_bitcoin_logo),
    ETHEREUM(id = "ethereum", nameRes = R.string.ethereum_cryptocurrency_name, iconRes = R.drawable.ic_ethereum_logo),
    TONCOIN(
        id = "the-open-network",
        nameRes = R.string.toncoin_cryptocurrency_name,
        iconRes = R.drawable.ic_toncoin_logo
    ),
    DOGCOIN(id = "dogcoin", nameRes = R.string.dogcoin_cryptocurrency_name, iconRes = R.drawable.ic_dogcoin_logo),
    TWT(id = "trust-wallet-token", nameRes = R.string.twt_cryptocurrency_name, iconRes = R.drawable.ic_twt_logo),
    MONERO(id = "monero", nameRes = R.string.moneiro_cryptocurrency_name, iconRes = R.drawable.ic_monero_logo),
    LITECOIN(id = "lightcoin", nameRes = R.string.litecoin_cryptocurrency_name, iconRes = R.drawable.ic_litecoin_logo),
    BINANCE(id = "binancecoin", nameRes = R.string.binance_cryptocurrency_name, iconRes = R.drawable.ic_binance_logo),
    TETHER(id = "tether", nameRes = R.string.tether_cryptocurrency_name, iconRes = R.drawable.ic_tether_logo);

    companion object {
        fun retrieveById(id: String): Cryptocurrency? = values().find { it.id == id }
    }
}