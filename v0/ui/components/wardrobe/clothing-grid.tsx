'use client'

import { ClothingItem } from '@/lib/wardrobe-data'
import { ClothingCard } from './clothing-card'
import { Search } from 'lucide-react'

interface ClothingGridProps {
  items: ClothingItem[]
  searchQuery: string
  onSearchChange: (query: string) => void
  categoryName: string
}

export function ClothingGrid({ 
  items, 
  searchQuery, 
  onSearchChange,
  categoryName
}: ClothingGridProps) {
  return (
    <div className="flex-1 flex flex-col min-w-0 bg-background">
      {/* 搜索栏 */}
      <div className="sticky top-0 z-10 px-3 py-3 bg-background/95 backdrop-blur-sm border-b border-border/50">
        <div className="relative">
          {/* 搜索框 - 拟物风格 */}
          <div className="relative flex items-center">
            <Search className="absolute left-3 w-4 h-4 text-muted-foreground pointer-events-none" />
            <input
              type="text"
              placeholder="搜索衣物..."
              value={searchQuery}
              onChange={(e) => onSearchChange(e.target.value)}
              className="
                w-full pl-9 pr-4 py-2.5 
                bg-input rounded-xl
                text-sm text-foreground placeholder:text-muted-foreground
                border border-border
                shadow-[inset_0_2px_4px_rgba(0,0,0,0.06)]
                focus:outline-none focus:ring-2 focus:ring-primary/30 focus:border-primary/50
                transition-all duration-200
              "
            />
          </div>
        </div>
        
        {/* 当前分类标题 */}
        <div className="flex items-center justify-between mt-3">
          <h2 className="text-base font-semibold text-foreground">
            {categoryName}
          </h2>
          <span className="text-xs text-muted-foreground bg-muted px-2 py-1 rounded-full">
            {items.length} 件
          </span>
        </div>
      </div>
      
      {/* 衣物网格 */}
      <div className="flex-1 overflow-y-auto p-3">
        {items.length > 0 ? (
          <div className="grid grid-cols-3 gap-2.5">
            {items.map((item) => (
              <ClothingCard key={item.id} item={item} />
            ))}
          </div>
        ) : (
          <div className="flex flex-col items-center justify-center h-64 text-center">
            <div className="w-16 h-16 rounded-full bg-muted flex items-center justify-center mb-3">
              <Search className="w-6 h-6 text-muted-foreground" />
            </div>
            <p className="text-muted-foreground text-sm">暂无衣物</p>
            <p className="text-muted-foreground/60 text-xs mt-1">
              点击右上角添加新衣物
            </p>
          </div>
        )}
      </div>
    </div>
  )
}
