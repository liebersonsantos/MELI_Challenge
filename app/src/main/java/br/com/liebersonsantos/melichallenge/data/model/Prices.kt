package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Prices(

    @SerializedName("id")
    val id: String,
    @SerializedName("prices")
    val prices: List<Prices>,
    @SerializedName("presentation")
    val presentation: Presentation,
    @SerializedName("payment_method_prices")
    val paymentMethodPrices: List<String>,
    @SerializedName("reference_prices")
    val referencePrices: List<ReferencePrices>,
    @SerializedName("purchase_discounts")
    val purchaseDiscounts: List<PurchaseDiscounts>
) : Serializable