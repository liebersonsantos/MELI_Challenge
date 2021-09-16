package br.com.liebersonsantos.melichallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Attributes (

    @SerializedName("id")
    val id : String,
    @SerializedName("value_id")
    val valueId : Int,
    @SerializedName("value_name")
    val valueName : String,
    @SerializedName("values")
    val values : List<Values>,
    @SerializedName("source")
    val source : Long,
    @SerializedName("name")
    val name : String,
    @SerializedName("value_struct")
    val valueStruct : ValueStruct,
    @SerializedName("attribute_group_id")
    val attributeGroupId : String,
    @SerializedName("attribute_group_name")
    val attributeGroupName : String
): Serializable