package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class SellerReputation(

    @SerializedName("transactions")
    val transactions: Transactions,
    @SerializedName("power_seller_status")
    val powerSellerStatus: String,
    @SerializedName("metrics")
    val metrics: Metrics,
    @SerializedName("level_id")
    val levelId: String
) : Serializable