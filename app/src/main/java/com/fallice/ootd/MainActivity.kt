package com.fallice.ootd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fallice.ootd.ui.theme.OotdTheme
import com.fallice.ootd.ui.theme.*

// ==========================================
// 数据模型
// ==========================================

data class ClothingItem(
    val id: String,
    val name: String,
    val category: String,
    val tags: List<String>,
    val image: String,
    val color: Color
)

data class Category(
    val id: String,
    val name: String,
    val icon: String,
    val count: Int
)

// ==========================================
// 示例数据
// ==========================================

val categories = listOf(
    Category(id = "all", name = "全部", icon = "👗", count = 24),
    Category(id = "tops", name = "上衣", icon = "👕", count = 8),
    Category(id = "bottoms", name = "下装", icon = "👖", count = 6),
    Category(id = "dresses", name = "连衣裙", icon = "👗", count = 4),
    Category(id = "outerwear", name = "外套", icon = "🧥", count = 3),
    Category(id = "shoes", name = "鞋子", icon = "👟", count = 5),
    Category(id = "bags", name = "包包", icon = "👜", count = 4),
    Category(id = "accessories", name = "配饰", icon = "💍", count = 6),
)

val clothingItems = listOf(
    ClothingItem(
        id = "1",
        name = "米白色针织开衫",
        category = "tops",
        tags = listOf("休闲", "春秋"),
        image = "",
        color = Color(0xFFF5F5DC)
    ),
    ClothingItem(
        id = "2",
        name = "深蓝色牛仔裤",
        category = "bottoms",
        tags = listOf("百搭", "日常"),
        image = "",
        color = Color(0xFF1E3A5F)
    ),
    ClothingItem(
        id = "3",
        name = "碎花连衣裙",
        category = "dresses",
        tags = listOf("优雅", "夏季"),
        image = "",
        color = Color(0xFFFFB6C1)
    ),
    ClothingItem(
        id = "4",
        name = "卡其色风衣",
        category = "outerwear",
        tags = listOf("经典", "秋冬"),
        image = "",
        color = Color(0xFFC3B091)
    ),
    ClothingItem(
        id = "5",
        name = "白色运动鞋",
        category = "shoes",
        tags = listOf("运动", "百搭"),
        image = "",
        color = Color(0xFFFFFFFF)
    ),
    ClothingItem(
        id = "6",
        name = "棕色托特包",
        category = "bags",
        tags = listOf("通勤", "大容量"),
        image = "",
        color = Color(0xFF8B4513)
    ),
    ClothingItem(
        id = "7",
        name = "灰色毛衣",
        category = "tops",
        tags = listOf("保暖", "秋冬"),
        image = "",
        color = Color(0xFF808080)
    ),
    ClothingItem(
        id = "8",
        name = "黑色西装裤",
        category = "bottoms",
        tags = listOf("正式", "通勤"),
        image = "",
        color = Color(0xFF2D2D2D)
    ),
    ClothingItem(
        id = "9",
        name = "粉色衬衫",
        category = "tops",
        tags = listOf("甜美", "春季"),
        image = "",
        color = Color(0xFFFFB6C1)
    ),
    ClothingItem(
        id = "10",
        name = "格纹半裙",
        category = "bottoms",
        tags = listOf("复古", "秋冬"),
        image = "",
        color = Color(0xFF8B0000)
    ),
    ClothingItem(
        id = "11",
        name = "黑色高跟鞋",
        category = "shoes",
        tags = listOf("正式", "优雅"),
        image = "",
        color = Color(0xFF1A1A1A)
    ),
    ClothingItem(
        id = "12",
        name = "珍珠项链",
        category = "accessories",
        tags = listOf("优雅", "百搭"),
        image = "",
        color = Color(0xFFFFFAF0)
    ),
)

// ==========================================
// 主 Activity
// ==========================================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OotdTheme {
                OotdApp()
            }
        }
    }
}

// ==========================================
// 主应用
// ==========================================

@Composable
fun OotdApp() {
    var activeTab by remember { mutableStateOf("wardrobe") }

    val pageTitles = mapOf(
        "wardrobe" to "我的衣橱",
        "outfits" to "穿搭灵感",
        "recommend" to "为你推荐",
        "profile" to "个人中心"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Header(title = pageTitles[activeTab] ?: "")

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when (activeTab) {
                    "wardrobe" -> WardrobePage()
                    "outfits" -> PlaceholderPage(
                        icon = Icons.Default.Star,
                        title = "穿搭灵感",
                        description = "发现精彩穿搭组合"
                    )
                    "recommend" -> PlaceholderPage(
                        icon = Icons.Default.Favorite,
                        title = "为你推荐",
                        description = "根据你的衣橱智能推荐"
                    )
                    "profile" -> PlaceholderPage(
                        icon = Icons.Default.Person,
                        title = "个人中心",
                        description = "管理你的账户设置"
                    )
                }
            }

            BottomTabs(
                activeTab = activeTab,
                onTabChange = { activeTab = it }
            )
        }
    }
}

// ==========================================
// Header 组件
// ==========================================

@Composable
fun Header(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp,
        tonalElevation = 0.5.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                WoodDark.copy(alpha = 0.3f),
                                WoodMedium.copy(alpha = 0.5f),
                                WoodDark.copy(alpha = 0.3f)
                            )
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Primary, PrimaryDark)
                                )
                            )
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(12.dp),
                                clip = false
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            tint = PrimaryForeground,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.outlineVariant,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { }
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = TextSecondary,
                                modifier = Modifier.size(18.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .offset(x = 4.dp, y = (-4).dp)
                                    .align(Alignment.TopEnd)
                                    .clip(CircleShape)
                                    .background(Color(0xFFEF4444))
                                    .border(
                                        width = 2.dp,
                                        color = MaterialTheme.colorScheme.surface,
                                        shape = CircleShape
                                    )
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Primary, PrimaryDark)
                                )
                            )
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(12.dp),
                                clip = false
                            )
                            .clickable { }
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = PrimaryForeground,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

// ==========================================
// Bottom Tabs 组件
// ==========================================

data class Tab(
    val id: String,
    val label: String,
    val icon: ImageVector
)

@Composable
fun BottomTabs(
    activeTab: String,
    onTabChange: (String) -> Unit
) {
    val tabs = listOf(
        Tab(id = "wardrobe", label = "衣橱", icon = Icons.Default.Home),
        Tab(id = "outfits", label = "穿搭", icon = Icons.Default.Star),
        Tab(id = "recommend", label = "推荐", icon = Icons.Default.Favorite),
        Tab(id = "profile", label = "我的", icon = Icons.Default.Person),
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        tonalElevation = 0.5.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.outlineVariant,
                                Color.Transparent
                            )
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .height(64.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                tabs.forEach { tab ->
                    val isActive = activeTab == tab.id
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onTabChange(tab.id) }
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(width = 48.dp, height = 32.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (isActive) {
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Primary.copy(alpha = 0.15f),
                                                Primary.copy(alpha = 0.05f)
                                            )
                                        )
                                    } else {
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, Color.Transparent)
                                        )
                                    }
                                )
                                .then(
                                    if (isActive) {
                                        Modifier.shadow(
                                            elevation = 2.dp,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                    } else {
                                        Modifier
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.label,
                                tint = if (isActive) Primary else TextTertiary,
                                modifier = Modifier.size(20.dp).let {
                                    if (isActive) it.then(Modifier.scale(1.1f)) else it
                                }
                            )

                            if (isActive) {
                                Box(
                                    modifier = Modifier
                                        .size(width = 4.dp, height = 4.dp)
                                        .align(Alignment.BottomCenter)
                                        .offset(y = 2.dp)
                                        .clip(CircleShape)
                                        .background(Primary)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = tab.label,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = if (isActive) FontWeight.Medium else FontWeight.Normal
                            ),
                            color = if (isActive) Primary else TextTertiary
                        )
                    }
                }
            }
        }
    }
}

// ==========================================
// 衣橱页面组件
// ==========================================

@Composable
fun WardrobePage() {
    var activeCategory by remember { mutableStateOf("all") }
    var searchQuery by remember { mutableStateOf("") }

    val filteredItems = remember(activeCategory, searchQuery) {
        clothingItems.filter { item ->
            val categoryMatch = activeCategory == "all" || item.category == activeCategory
            val searchMatch = searchQuery.isEmpty() ||
                    item.name.contains(searchQuery, ignoreCase = true) ||
                    item.tags.any { it.contains(searchQuery, ignoreCase = true) }
            categoryMatch && searchMatch
        }
    }

    val currentCategoryName = remember(activeCategory) {
        categories.find { it.id == activeCategory }?.name ?: "全部"
    }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        CategorySidebar(
            categories = categories,
            activeCategory = activeCategory,
            onCategoryChange = { activeCategory = it }
        )

        ClothingGrid(
            items = filteredItems,
            searchQuery = searchQuery,
            onSearchChange = { searchQuery = it },
            categoryName = currentCategoryName
        )
    }
}

// ==========================================
// 分类侧边栏组件
// ==========================================

@Composable
fun CategorySidebar(
    categories: List<Category>,
    activeCategory: String,
    onCategoryChange: (String) -> Unit
) {
    Surface(
        modifier = Modifier.width(80.dp),
        color = SurfaceVariant,
        shadowElevation = 0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                WoodDark.copy(alpha = 0.3f),
                                WoodMedium.copy(alpha = 0.5f),
                                WoodDark.copy(alpha = 0.3f)
                            )
                        )
                    )
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(categories) { category ->
                    val isActive = activeCategory == category.id
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onCategoryChange(category.id) }
                            .padding(vertical = 12.dp, horizontal = 8.dp)
                            .then(
                                if (isActive) {
                                    Modifier.background(MaterialTheme.colorScheme.surface)
                                } else {
                                    Modifier
                                }
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (isActive) {
                            Box(
                                modifier = Modifier
                                    .width(4.dp)
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                                    .background(Primary)
                                    .align(Alignment.Start)
                                    .offset(x = (-8).dp)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.surface,
                                            SurfaceVariant
                                        )
                                    )
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (isActive) Primary.copy(alpha = 0.3f)
                                    else MaterialTheme.colorScheme.outlineVariant,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .then(
                                    if (isActive) {
                                        Modifier.shadow(
                                            elevation = 2.dp,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                    } else {
                                        Modifier
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = category.icon,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = if (isActive) FontWeight.SemiBold else FontWeight.Medium
                            ),
                            color = if (isActive) Primary else TextSecondary
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Surface(
                            shape = CircleShape,
                            color = if (isActive) Primary.copy(alpha = 0.1f) else Muted,
                            tonalElevation = 0.dp
                        ) {
                            Text(
                                text = category.count.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = if (isActive) Primary else TextTertiary,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 16.dp)
                    .height(1.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.outlineVariant,
                                Color.Transparent
                            )
                        )
                    )
            )
        }
    }
}

// ==========================================
// 衣物网格组件
// ==========================================

@Composable
fun ClothingGrid(
    items: List<ClothingItem>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    categoryName: String
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 1.dp,
            tonalElevation = 0.3.dp
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = TextTertiary
                        )
                    },
                    placeholder = {
                        Text(
                            text = "搜索衣物...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextTertiary
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        focusedBorderColor = Primary,
                    ),
                    textStyle = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = categoryName,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Surface(
                        shape = CircleShape,
                        color = Muted,
                        tonalElevation = 0.dp
                    ) {
                        Text(
                            text = "${items.size} 件",
                            style = MaterialTheme.typography.labelSmall,
                            color = TextTertiary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }

        if (items.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(items) { item ->
                    ClothingCard(item = item)
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(Muted),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = TextTertiary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "暂无衣物",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextTertiary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "点击右上角添加新衣物",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextTertiary.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

// ==========================================
// 衣物卡片组件
// ==========================================

@Composable
fun ClothingCard(item: ClothingItem) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp,
        tonalElevation = 0.5.dp,
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item.color)
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .align(Alignment.Center)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.3f))
                            .shadow(elevation = 4.dp, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 4.dp,
                            color = WoodLight.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.White.copy(alpha = 0.2f),
                                    Color.Transparent,
                                    Color.Transparent
                                )
                            )
                        )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    item.tags.take(2).forEach { tag ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Muted,
                            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                            tonalElevation = 0.dp
                        ) {
                            Text(
                                text = tag,
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondary,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                WoodLight.copy(alpha = 0.4f),
                                WoodMedium.copy(alpha = 0.6f),
                                WoodLight.copy(alpha = 0.4f)
                            )
                        )
                    )
            )
        }
    }
}

// ==========================================
// 占位页面组件
// ==========================================

@Composable
fun PlaceholderPage(
    icon: ImageVector,
    title: String,
    description: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Muted, Accent)
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = TextTertiary,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "功能开发中...",
                style = MaterialTheme.typography.bodySmall,
                color = TextTertiary.copy(alpha = 0.6f)
            )
        }
    }
}
