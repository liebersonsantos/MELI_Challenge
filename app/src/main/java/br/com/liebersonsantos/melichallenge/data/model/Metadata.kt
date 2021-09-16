package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Metadata(

    @SerializedName("promotion_id")
    val promotionId: String,
    @SerializedName("promotion_type")
    val promotionType: String
) : Serializable