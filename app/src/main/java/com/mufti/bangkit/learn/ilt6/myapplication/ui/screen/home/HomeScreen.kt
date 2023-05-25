package com.mufti.bangkit.learn.ilt6.myapplication.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mufti.bangkit.learn.ilt6.myapplication.model.Hero
import com.mufti.bangkit.learn.ilt6.myapplication.ui.component.HeroItem

@Composable
fun HomeScreen(
    listHero: List<Hero>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    Box(modifier = modifier) {
        HomeContent(
            listHero = listHero,
            modifier = modifier,
            navigateToDetail = navigateToDetail,
        )
    }
}

@Composable
fun HomeContent(
    listHero: List<Hero>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listHero) { data ->
            HeroItem(
                hero = data,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToDetail(data.id)
                    }
            )
        }
    }
}