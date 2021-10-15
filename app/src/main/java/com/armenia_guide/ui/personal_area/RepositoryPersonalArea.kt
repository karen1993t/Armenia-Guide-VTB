package com.armenia_guide.ui.personal_area

import com.armenia_guide.ui.personal_area.entity.ModelPersonalArea

interface RepositoryPersonalArea {
   suspend fun getListPersonalArea():List<ModelPersonalArea>
}