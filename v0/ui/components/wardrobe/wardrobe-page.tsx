'use client'

import { useState, useMemo } from 'react'
import { categories, clothingItems, ClothingItem } from '@/lib/wardrobe-data'
import { CategorySidebar } from './category-sidebar'
import { ClothingGrid } from './clothing-grid'

export function WardrobePage() {
  const [activeCategory, setActiveCategory] = useState('all')
  const [searchQuery, setSearchQuery] = useState('')

  // 根据分类和搜索筛选衣物
  const filteredItems = useMemo(() => {
    let items: ClothingItem[] = clothingItems

    // 按分类筛选
    if (activeCategory !== 'all') {
      items = items.filter(item => item.category === activeCategory)
    }

    // 按搜索关键词筛选
    if (searchQuery.trim()) {
      const query = searchQuery.toLowerCase()
      items = items.filter(item => 
        item.name.toLowerCase().includes(query) ||
        item.tags.some(tag => tag.toLowerCase().includes(query))
      )
    }

    return items
  }, [activeCategory, searchQuery])

  // 获取当前分类名称
  const currentCategoryName = useMemo(() => {
    return categories.find(c => c.id === activeCategory)?.name || '全部'
  }, [activeCategory])

  return (
    <div className="flex flex-1 min-h-0 overflow-hidden">
      {/* 左侧分类栏 */}
      <CategorySidebar
        categories={categories}
        activeCategory={activeCategory}
        onCategoryChange={setActiveCategory}
      />
      
      {/* 右侧衣物列表 */}
      <ClothingGrid
        items={filteredItems}
        searchQuery={searchQuery}
        onSearchChange={setSearchQuery}
        categoryName={currentCategoryName}
      />
    </div>
  )
}
