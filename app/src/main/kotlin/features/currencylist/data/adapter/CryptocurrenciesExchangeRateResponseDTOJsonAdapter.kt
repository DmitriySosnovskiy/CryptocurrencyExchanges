package features.currencylist.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import features.currencylist.data.model.ExchangeRateDTO
import java.math.BigDecimal

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class CryptocurrenciesExchangeRateResponseDTOJsonAdapter : JsonAdapter<List<ExchangeRateDTO>>() {

    @FromJson
    override fun fromJson(jsonReader: JsonReader): List<ExchangeRateDTO>? {
        val exchangeRateList = mutableListOf<ExchangeRateDTO>()

        jsonReader.beginObject()
        while (jsonReader.hasNext()) {
            val id = jsonReader.nextName()
            val exchangeRateDTO = readExchangeRateDTO(jsonReader, id)
            exchangeRateList.add(exchangeRateDTO)
        }
        jsonReader.endObject()

        return exchangeRateList
    }

    private fun readExchangeRateDTO(jsonReader: JsonReader, id: String): ExchangeRateDTO {
        var priceInUsd: BigDecimal = BigDecimal.ZERO
        var priceInEur: BigDecimal = BigDecimal.ZERO
        var priceInRub: BigDecimal = BigDecimal.ZERO
        var lastUpdatedAt = 0L

        jsonReader.beginObject()
        while (jsonReader.hasNext()) {
            when (jsonReader.nextName()) {
                "usd" -> priceInUsd = jsonReader.nextDouble().toBigDecimal()
                "eur" -> priceInEur = jsonReader.nextDouble().toBigDecimal()
                "rub" -> priceInRub = jsonReader.nextDouble().toBigDecimal()
                "last_updated_at" -> lastUpdatedAt = jsonReader.nextLong() * 1000L
                else -> jsonReader.skipValue()
            }
        }
        jsonReader.endObject()

        return ExchangeRateDTO(id, priceInUsd, priceInEur, priceInRub, lastUpdatedAt)
    }

    override fun toJson(writer: JsonWriter, value: List<ExchangeRateDTO>?) {
        TODO("Not yet implemented")
    }
}