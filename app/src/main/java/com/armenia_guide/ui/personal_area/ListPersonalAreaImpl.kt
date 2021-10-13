package com.armenia_guide.ui.personal_area

import com.armenia_guide.R
import com.armenia_guide.ui.personal_area.entity.ModelPersonalArea

class ListPersonalAreaImpl : RepositoryPersonalArea {

    private val list = listOf(
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Income", "21:30", "+2 241 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),

        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Income", "21:30", "+2 241 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Income", "21:30", "+2 241 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Income", "21:30", "+2 241 288 ₽"),
        ModelPersonalArea(R.drawable.ic_logo_guide, "Hilton Hotel", "20:30", "-196 435 ₽"),
        ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
        ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
    )

    override suspend fun getListPersonalArea(): List<ModelPersonalArea> {
        return list
    }
}