package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Installments(

    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("currency_id")
    val currencyId: String
) : Serializable