package com.surivalcoding.composerecipeapp.presentation.search_recipes.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.FilterButton
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchFilter
import com.surivalcoding.composerecipeapp.presentation.search_recipes.TimeFilter
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSearchBottomSheet(
    modifier: Modifier = Modifier,
    searchFilter: SearchFilter,
    categories: List<String>,
    onTimeFilterChange: (TimeFilter) -> Unit,
    onCategoryFilterChange: (String) -> Unit,
    onRateFilterChange: (Int) -> Unit,
    onDismissRequest: () -> Unit = {},
) {
    ModalBottomSheet(
        modifier = modifier
            .fillMaxHeight(),
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = false,
        ),
        onDismissRequest = onDismissRequest,
        containerColor = AppColors.white,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Filter Search", style = AppTextStyles.smallTextBold)
            Spacer(modifier = Modifier.height(20.dp))
            VerticalFilterList(
                filterTitle = "Time",
                items = TimeFilter.entries.map { it },
                onFilterSelected = { onTimeFilterChange(it) },
                selectedFilter = searchFilter.timeFilter
            )
            Spacer(modifier = Modifier.height(20.dp))
            VerticalFilterList(
                filterTitle = "Rate",
                icon = Icons.Default.Star,
                items = (1..5).reversed().map { it },
                onFilterSelected = { onRateFilterChange(it) },
                selectedFilter = searchFilter.rateFilter
            )
            Spacer(modifier = Modifier.height(20.dp))
            VerticalFilterList(
                filterTitle = "Category",
                items = categories,
                onFilterSelected = { onCategoryFilterChange(it) },
                selectedFilter = searchFilter.category.ifBlank {
                    categories.first()
                }
            )
        }
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T> VerticalFilterList(
    modifier: Modifier = Modifier,
    filterTitle: String,
    icon: ImageVector? = null,
    items: List<T>,
    onFilterSelected: (T) -> Unit,
    selectedFilter: T,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(filterTitle, style = AppTextStyles.smallTextBold)
        Spacer(modifier = Modifier.height(10.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items.map { filter ->
                FilterButton(
                    buttonText = filter.toString(),
                    icon = icon,
                    onClickButton = { onFilterSelected(filter) },
                    isSelected = selectedFilter == filter
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterSearchBottomSheetPreview() {
    FilterSearchBottomSheet(
        searchFilter = SearchFilter.default(),
        onDismissRequest = { },
        categories = emptyList(),
        onTimeFilterChange = {},
        onCategoryFilterChange = {},
        onRateFilterChange = {},
    )
}