'use client'

import { cn } from '@/lib/utils'
import { Shirt, Sparkles, Heart, User } from 'lucide-react'

interface Tab {
  id: string
  label: string
  icon: React.ReactNode
}

const tabs: Tab[] = [
  { id: 'wardrobe', label: '衣橱', icon: <Shirt className="w-5 h-5" /> },
  { id: 'outfits', label: '穿搭', icon: <Sparkles className="w-5 h-5" /> },
  { id: 'recommend', label: '推荐', icon: <Heart className="w-5 h-5" /> },
  { id: 'profile', label: '我的', icon: <User className="w-5 h-5" /> },
]

interface BottomTabsProps {
  activeTab: string
  onTabChange: (tabId: string) => void
}

export function BottomTabs({ activeTab, onTabChange }: BottomTabsProps) {
  return (
    <nav className={cn(
      "sticky bottom-0 z-20",
      "bg-gradient-to-t from-card to-card/98",
      "border-t border-border/60",
      "shadow-[0_-4px_16px_rgba(0,0,0,0.04)]"
    )}>
      <div className="flex items-center justify-around px-2 py-1 pb-safe">
        {tabs.map((tab) => (
          <button
            key={tab.id}
            onClick={() => onTabChange(tab.id)}
            className={cn(
              "flex-1 flex flex-col items-center gap-0.5 py-2 px-1",
              "transition-all duration-200",
              "group"
            )}
          >
            {/* 图标容器 */}
            <div className={cn(
              "relative w-12 h-8 flex items-center justify-center rounded-xl",
              "transition-all duration-300",
              activeTab === tab.id ? [
                "bg-gradient-to-br from-primary/15 to-primary/5",
                "shadow-[0_2px_8px_rgba(0,0,0,0.04)]"
              ] : "group-hover:bg-muted/50"
            )}>
              <span className={cn(
                "transition-all duration-200",
                activeTab === tab.id 
                  ? "text-primary scale-110" 
                  : "text-muted-foreground group-hover:text-foreground/80"
              )}>
                {tab.icon}
              </span>
              
              {/* 活跃指示器 */}
              {activeTab === tab.id && (
                <span className="absolute -bottom-0.5 w-1 h-1 rounded-full bg-primary" />
              )}
            </div>
            
            {/* 标签文字 */}
            <span className={cn(
              "text-[10px] font-medium transition-colors duration-200",
              activeTab === tab.id 
                ? "text-primary" 
                : "text-muted-foreground group-hover:text-foreground/80"
            )}>
              {tab.label}
            </span>
          </button>
        ))}
      </div>
      
      {/* 底部安全区域装饰线 */}
      <div className="h-0.5 bg-gradient-to-r from-transparent via-border to-transparent" />
    </nav>
  )
}
