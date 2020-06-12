package com.example.gitbook.ui

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Users : ArrayList<UsersItem>()

@Entity(tableName = "users")
data class UsersItem(
    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    @Expose
    val avatar_url: String?,

    @SerializedName("events_url")
    @ColumnInfo(name = "events_url")
    @Expose
    val events_url: String?,

    @SerializedName("followers_url")
    @ColumnInfo(name = "followers_url")
    @Expose
    val followers_url: String?,

    @SerializedName("following_url")
    @ColumnInfo(name = "following_url")
    @Expose
    val following_url: String?,

    @SerializedName("gists_url")
    @ColumnInfo(name = "gists_url")
    @Expose
    val gists_url: String?,

    @SerializedName("gravatar_id")
    @ColumnInfo(name = "gravatar_id")
    @Expose
    val gravatar_id: String?,

    @SerializedName("html_url")
    @ColumnInfo(name = "html_url")
    @Expose
    val html_url: String?,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @Expose
    val id: Int,

    @SerializedName("login")
    @ColumnInfo(name = "login")
    @Expose
    val login: String?,

    @SerializedName("node_id")
    @ColumnInfo(name = "node_id")
    @Expose
    val node_id: String?,

    @SerializedName("organizations_url")
    @ColumnInfo(name = "organizations_url")
    @Expose
    val organizations_url: String?,

    @SerializedName("received_events_url")
    @ColumnInfo(name = "received_events_url")
    @Expose
    val received_events_url: String?,

    @SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    @Expose
    val repos_url: String?,

    @SerializedName("site_admin")
    @ColumnInfo(name = "site_admin")
    @Expose
    val site_admin: Boolean,

    @SerializedName("starred_url")
    @ColumnInfo(name = "starred_url")
    @Expose
    val starred_url: String?,

    @SerializedName("subscriptions_url")
    @ColumnInfo(name = "subscriptions_url")
    @Expose
    val subscriptions_url: String?,

    @SerializedName("type")
    @ColumnInfo(name = "type")
    @Expose
    val type: String?,

    @SerializedName("url")
    @ColumnInfo(name = "url")
    @Expose
    val url: String?


) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        1 == source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(avatar_url)
        writeString(events_url)
        writeString(followers_url)
        writeString(following_url)
        writeString(gists_url)
        writeString(gravatar_id)
        writeString(html_url)
        writeInt(id)
        writeString(login)
        writeString(node_id)
        writeString(organizations_url)
        writeString(received_events_url)
        writeString(repos_url)
        writeInt((if (site_admin) 1 else 0))
        writeString(starred_url)
        writeString(subscriptions_url)
        writeString(type)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UsersItem> = object : Parcelable.Creator<UsersItem> {
            override fun createFromParcel(source: Parcel): UsersItem = UsersItem(source)
            override fun newArray(size: Int): Array<UsersItem?> = arrayOfNulls(size)
        }
    }
}