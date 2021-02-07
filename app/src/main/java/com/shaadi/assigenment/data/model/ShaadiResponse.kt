package com.shaadi.assigenment.data.model

import android.os.Parcelable
import androidx.annotation.Nullable
import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ShaadiResponse(

    @field:SerializedName("results")
    var results: List<ResultsItem>,


    @field:SerializedName("info")
    var info: Info?
) : Parcelable

@Parcelize
data class Picture(
    @Nullable
    @field:SerializedName("thumbnail")
    var thumbnail: String?,

    @Nullable
    @field:SerializedName("large")
    var large: String?,

    @Nullable
    @field:SerializedName("medium")
    var medium: String?
) : Parcelable

@Parcelize
data class Info(

    @Nullable
    @field:SerializedName("seed")
    var seed: String?,

    @Nullable
    @field:SerializedName("page")
    var page: Int?,

    @Nullable
    @field:SerializedName("results")
    var results: Int?,

    @Nullable
    @field:SerializedName("version")
    var version: String?
) : Parcelable

@Parcelize
data class Street(

    @Nullable
    @field:SerializedName("number")
    var number: Int?,

    @Nullable
    @field:SerializedName("name")
    var streetName: String?
) : Parcelable

@Parcelize
data class Id(

    @Nullable
    @field:SerializedName("name")
    var idName: String?,


    @field:SerializedName("varue")
    @Nullable
    var varue: String?
) : Parcelable


@Parcelize
@Entity(
    tableName = "card", indices = [Index(
        value = ["email"],
        unique = true
    )]
)
data class ResultsItem(


    @Nullable
    @field:SerializedName("nat")
    var nat: String?,

    @Nullable
    @field:SerializedName("gender")
    var gender: String?,

    @Nullable
    @field:SerializedName("phone")
    var phone: String?,

    @Embedded
    @Nullable
    @field:SerializedName("dob")
    var dob: Dob?,

    @Embedded
    @Nullable
    @field:SerializedName("name")
    var name: Name?,

    @Embedded
    @Nullable
    @field:SerializedName("registered")
    var registered: Registered?,

    @Embedded
    @Nullable
    @field:SerializedName("location")
    var location: Location?,

    @Embedded
    @Nullable
    @field:SerializedName("id")
    var id: Id?,

    @Embedded
    @Nullable
    @field:SerializedName("login")
    var login: Login?,

    @Nullable
    @field:SerializedName("cell")
    var cell: String?,

    @PrimaryKey
    @Nullable
    @field:SerializedName("email")
    var email: String,

    @Embedded
    @Nullable
    @field:SerializedName("picture")
    var picture: Picture?




) : Parcelable {
    @Expose
	@ColumnInfo(name ="isActionTaken")
	var isActionTaken: Boolean?=null

	//
	@Expose
	@ColumnInfo(name ="actionName")
	var actionName: String? = null

}


@Parcelize
data class Timezone(

    @Nullable
    @field:SerializedName("offset")
    var offset: String?,

    @Nullable
    @field:SerializedName("description")
    var description: String?
) : Parcelable

@Parcelize
data class Login(

    @Nullable
    @field:SerializedName("sha1")
    var sha1: String?,

    @Nullable
    @field:SerializedName("password")
    var password: String?,

    @Nullable
    @field:SerializedName("salt")
    var salt: String?,

    @Nullable
    @field:SerializedName("sha256")
    var sha256: String?,

    @Nullable
    @field:SerializedName("uuid")
    var uuid: String?,

    @Nullable
    @field:SerializedName("username")
    var username: String?,

    @Nullable
    @field:SerializedName("md5")
    var md5: String?
) : Parcelable

@Parcelize
data class Name(

    @Nullable
    @field:SerializedName("last")
    var last: String?,

    @Nullable
    @field:SerializedName("title")
    var title: String?,

    @Nullable
    @field:SerializedName("first")
    var first: String?
) : Parcelable

@Parcelize
data class Registered(


    @Nullable
    @field:SerializedName("date")
    var joineddate: String?,

    @Nullable
    @field:SerializedName("age")
    var register_age: Int?

) : Parcelable

@Parcelize
data class Coordinates(

    @Nullable
    @field:SerializedName("latitude")
    var latitude: String?,

    @Nullable
    @field:SerializedName("longitude")
    var longitude: String?
) : Parcelable

@Parcelize
data class Location(

    @Nullable
    @field:SerializedName("country")
    var country: String?,

    @Nullable
    @field:SerializedName("city")
    var city: String?,

    @Embedded
    @Nullable
    @field:SerializedName("street")
    var street: Street?,

    @Embedded
    @Nullable
    @field:SerializedName("timezone")
    var timezone: Timezone?,

    @Nullable
    @field:SerializedName("postcode")
    var postcode: String?,

    @Embedded
    @Nullable
    @field:SerializedName("coordinates")
    var coordinates: Coordinates?,

    @Nullable
    @field:SerializedName("state")
    var state: String?


) : Parcelable

@Parcelize
data class Dob(

    @Nullable
    @field:SerializedName("date")
    var date: String?,

    @Nullable
    @field:SerializedName("age")
    var age: Int?
) : Parcelable {
    fun getAgeAsString(): String {
        return age.toString()
    }
}
