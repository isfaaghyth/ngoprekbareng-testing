package id.ngoprek.testing.arch.ui.uimodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize data class LoginUIModel(
    val id: String,
    val username: String,
    val name: String,
    val email: String
) : Parcelable