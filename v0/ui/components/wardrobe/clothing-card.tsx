'use client'

import { ClothingItem } from '@/lib/wardrobe-data'
import { cn } from '@/lib/utils'

interface ClothingCardProps {
  item: ClothingItem
}

export function ClothingCard({ item }: ClothingCardProps) {
  return (
    <div className={cn(
      "group relative flex flex-col",
      "bg-card rounded-xl overflow-hidden",
      "shadow-[0_2px_8px_rgba(0,0,0,0.06),0_1px_2px_rgba(0,0,0,0.04)]",
      "border border-border/60",
      "transition-all duration-300",
      "hover:shadow-[0_8px_24px_rgba(0,0,0,0.1),0_2px_4px_rgba(0,0,0,0.06)]",
      "hover:scale-[1.02] hover:-translate-y-0.5"
    )}>
      {/* 图片容器 - 拟物相框效果 */}
      <div className="relative aspect-square overflow-hidden bg-muted">
        {/* 木质相框内边框 */}
        <div className="absolute inset-0 border-4 border-amber-100/50 rounded-t-lg z-10 pointer-events-none shadow-[inset_0_0_8px_rgba(0,0,0,0.08)]" />
        
        {/* 衣物图片占位 - 使用颜色块模拟 */}
        <div 
          className="w-full h-full flex items-center justify-center"
          style={{ backgroundColor: item.color }}
        >
          {/* 衣物图标装饰 */}
          <div className="w-16 h-16 rounded-full bg-white/30 backdrop-blur-sm flex items-center justify-center shadow-lg">
            <svg 
              className="w-8 h-8 text-white/80 drop-shadow-md" 
              fill="none" 
              viewBox="0 0 24 24" 
              stroke="currentColor"
            >
              <path 
                strokeLinecap="round" 
                strokeLinejoin="round" 
                strokeWidth={1.5} 
                d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2" 
              />
            </svg>
          </div>
        </div>
        
        {/* 光泽效果 */}
        <div className="absolute inset-0 bg-gradient-to-br from-white/20 via-transparent to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300 pointer-events-none" />
      </div>
      
      {/* 信息区域 */}
      <div className="p-2.5 space-y-1.5 bg-gradient-to-b from-card to-card/95">
        {/* 衣物名称 */}
        <h3 className="text-xs font-medium text-card-foreground truncate leading-tight">
          {item.name}
        </h3>
        
        {/* 标签 */}
        <div className="flex flex-wrap gap-1">
          {item.tags.slice(0, 2).map((tag) => (
            <span
              key={tag}
              className={cn(
                "inline-flex items-center px-1.5 py-0.5 rounded-md text-[10px]",
                "bg-gradient-to-r from-secondary to-muted",
                "text-muted-foreground font-medium",
                "border border-border/40",
                "shadow-[0_1px_2px_rgba(0,0,0,0.04)]"
              )}
            >
              {tag}
            </span>
          ))}
        </div>
      </div>
      
      {/* 底部木纹装饰线 */}
      <div className="h-0.5 bg-gradient-to-r from-amber-200/40 via-amber-300/60 to-amber-200/40" />
    </div>
  )
}
