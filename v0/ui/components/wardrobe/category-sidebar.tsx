'use client'

import { Category } from '@/lib/wardrobe-data'
import { cn } from '@/lib/utils'

interface CategorySidebarProps {
  categories: Category[]
  activeCategory: string
  onCategoryChange: (categoryId: string) => void
}

export function CategorySidebar({ 
  categories, 
  activeCategory, 
  onCategoryChange 
}: CategorySidebarProps) {
  return (
    <aside className="w-20 flex-shrink-0 bg-sidebar border-r border-sidebar-border overflow-y-auto">
      {/* 木质纹理装饰条 */}
      <div className="h-1 bg-gradient-to-r from-amber-700/30 via-amber-600/50 to-amber-700/30" />
      
      <nav className="py-2">
        {categories.map((category) => (
          <button
            key={category.id}
            onClick={() => onCategoryChange(category.id)}
            className={cn(
              "w-full flex flex-col items-center gap-1 py-3 px-2 transition-all duration-200",
              "hover:bg-sidebar-accent/50",
              activeCategory === category.id && [
                "bg-sidebar-accent",
                "relative",
                "before:absolute before:left-0 before:top-1/2 before:-translate-y-1/2",
                "before:w-1 before:h-8 before:bg-primary before:rounded-r-full",
                "shadow-[inset_0_1px_2px_rgba(0,0,0,0.05)]"
              ]
            )}
          >
            {/* 分类图标容器 - 拟物风格 */}
            <div className={cn(
              "w-11 h-11 rounded-xl flex items-center justify-center text-xl",
              "bg-gradient-to-br from-card to-muted",
              "shadow-[0_2px_4px_rgba(0,0,0,0.08),inset_0_1px_0_rgba(255,255,255,0.8)]",
              "border border-border/50",
              activeCategory === category.id && "ring-2 ring-primary/30"
            )}>
              <span className="drop-shadow-sm">{category.icon}</span>
            </div>
            
            {/* 分类名称 */}
            <span className={cn(
              "text-xs font-medium text-sidebar-foreground/80",
              activeCategory === category.id && "text-primary font-semibold"
            )}>
              {category.name}
            </span>
            
            {/* 数量标签 */}
            <span className={cn(
              "text-[10px] px-1.5 py-0.5 rounded-full",
              "bg-muted text-muted-foreground",
              activeCategory === category.id && "bg-primary/10 text-primary"
            )}>
              {category.count}
            </span>
          </button>
        ))}
      </nav>
      
      {/* 底部装饰 */}
      <div className="mt-auto px-3 pb-4">
        <div className="h-px bg-gradient-to-r from-transparent via-border to-transparent" />
      </div>
    </aside>
  )
}
