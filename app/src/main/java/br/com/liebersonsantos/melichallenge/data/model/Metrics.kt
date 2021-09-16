package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Metrics(

    @SerializedName("claims")
    val claims: Claims,
    @SerializedName("delayed_handling_time")
    val delayedHandlingTime: DelayedHandlingTime,
    @SerializedName("sales")
    val sales: Sales,
    @SerializedName("cancellations")
    val cancellations: Cancellations
) : Serializable