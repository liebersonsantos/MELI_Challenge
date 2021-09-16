package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Paging(
    @SerializedName("total")
    val total: Int,
    @SerializedName("primary_results")
    val primaryResults: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int
) : Serializable