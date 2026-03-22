'use client'

import { Plus, Bell } from 'lucide-react'
import { cn } from '@/lib/utils'

interface HeaderProps {
  title: string
}

export function Header({ title }: HeaderProps) {
  return (
    <header className={cn(
      "sticky top-0 z-20",
      "bg-gradient-to-b from-card to-card/98",
      "border-b border-border/60",
      "shadow-[0_2px_8px_rgba(0,0,0,0.04)]"
    )}>
      {/* 木质纹理顶部装饰 */}
      <div className="h-1 bg-gradient-to-r from-amber-600/40 via-amber-500/60 to-amber-600/40" />
      
      <div className="flex items-center justify-between px-4 py-3">
        {/* 左侧标题 */}
        <div className="flex items-center gap-3">
          {/* App图标 - 拟物衣架 */}
          <div className={cn(
            "w-9 h-9 rounded-xl flex items-center justify-center",
            "bg-gradient-to-br from-primary to-primary/80",
            "shadow-[0_3px_6px_rgba(0,0,0,0.15),inset_0_1px_0_rgba(255,255,255,0.2)]"
          )}>
            <svg className="w-5 h-5 text-primary-foreground" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 8h14M5 8a2 2 0 110-4h14a2 2 0 110 4M5 8v10a2 2 0 002 2h10a2 2 0 002-2V8" />
            </svg>
          </div>
          
          <h1 className="text-lg font-bold text-foreground tracking-tight">
            {title}
          </h1>
        </div>
        
        {/* 右侧操作按钮 */}
        <div className="flex items-center gap-2">
          {/* 通知按钮 */}
          <button className={cn(
            "relative w-9 h-9 rounded-xl flex items-center justify-center",
            "bg-muted hover:bg-accent/50",
            "border border-border/60",
            "shadow-[0_2px_4px_rgba(0,0,0,0.04)]",
            "transition-all duration-200"
          )}>
            <Bell className="w-4.5 h-4.5 text-muted-foreground" />
            {/* 通知红点 */}
            <span className="absolute top-1.5 right-1.5 w-2 h-2 bg-red-500 rounded-full border border-card" />
          </button>
          
          {/* 添加按钮 */}
          <button className={cn(
            "w-9 h-9 rounded-xl flex items-center justify-center",
            "bg-gradient-to-br from-primary to-primary/85",
            "shadow-[0_3px_6px_rgba(0,0,0,0.12),inset_0_1px_0_rgba(255,255,255,0.15)]",
            "hover:shadow-[0_4px_8px_rgba(0,0,0,0.16)]",
            "active:scale-95",
            "transition-all duration-200"
          )}>
            <Plus className="w-5 h-5 text-primary-foreground" />
          </button>
        </div>
      </div>
    </header>
  )
}
