package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class ReferencePrices(

    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("conditions")
    val conditions: Conditions,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("last_updated")
    val lastUpdated: String
) : Serializable