package com.example.imctm.model

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.example.imctm.R

class Imc (var weight: Double, var height: Double, var name: String, var gender: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    fun calculateImc(context: Context): String {
        val imcResult = this.weight / (this.height * this.height)

        if (gender == "Masculino") {
            return when(imcResult) {
                in 0.1..20.7 -> context.getString(R.string.under_weight)
                in 20.7..26.4 -> context.getString(R.string.good_weight)
                in 26.4..27.8 -> context.getString(R.string.over_weight)
                in 27.8..31.1 ->  context.getString(R.string.obesity_weight1)
                in 30.0..34.99 -> context.getString(R.string.obesity_weight2)
                else -> context.getString(R.string.obesity_weight3)
            }
        } else if (gender == "Feminino"){
            return when(imcResult) {
                in 0.1..19.1 -> context.getString(R.string.under_weight)
                in 19.1..25.8 -> context.getString(R.string.good_weight)
                in 25.8..27.3 -> context.getString(R.string.over_weight)
                in 27.3..32.3 ->  context.getString(R.string.obesity_weight1)
                in 32.0..34.9 -> context.getString(R.string.obesity_weight2)
                else -> context.getString(R.string.obesity_weight3)
            }
        } else {
            return when(imcResult) {
                in 0.1..17.0 -> context.getString(R.string.very_under_weight)
                in 17.1..18.49 -> context.getString(R.string.under_weight)
                in 18.5..24.99 -> context.getString(R.string.good_weight)
                in 25.0..29.99 ->  context.getString(R.string.over_weight)
                in 30.0..34.99 -> context.getString(R.string.obesity_weight1)
                in 35.0..39.99 -> context.getString(R.string.obesity_weight2)
                else -> context.getString(R.string.obesity_weight3)
            }
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeDouble(weight)
        dest?.writeDouble(height)
        dest?.writeString(name)
        dest?.writeString(gender)
    }

    companion object CREATOR : Parcelable.Creator<Imc> {
        override fun createFromParcel(parcel: Parcel): Imc {
            return Imc(parcel)
        }

        override fun newArray(size: Int): Array<Imc?> {
            return arrayOfNulls(size)
        }
    }
}