package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class City (

    @SerializedName("id")
    val id : String,
    @SerializedName("name")
    val name : String
): Serializable