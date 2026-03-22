'use client'

import { useState } from 'react'
import { Header } from '@/components/layout/header'
import { BottomTabs } from '@/components/layout/bottom-tabs'
import { WardrobePage } from '@/components/wardrobe/wardrobe-page'
import { Sparkles, Heart, User } from 'lucide-react'

// 页面标题映射
const pageTitles: Record<string, string> = {
  wardrobe: '我的衣橱',
  outfits: '穿搭灵感',
  recommend: '为你推荐',
  profile: '个人中心',
}

export default function App() {
  const [activeTab, setActiveTab] = useState('wardrobe')

  return (
    <div className="flex flex-col h-screen bg-background overflow-hidden">
      {/* 顶部栏 */}
      <Header title={pageTitles[activeTab]} />
      
      {/* 主内容区域 */}
      <main className="flex-1 flex flex-col min-h-0 overflow-hidden">
        {activeTab === 'wardrobe' && <WardrobePage />}
        
        {activeTab === 'outfits' && (
          <PlaceholderPage 
            icon={<Sparkles className="w-12 h-12" />}
            title="穿搭灵感"
            description="发现精彩穿搭组合"
          />
        )}
        
        {activeTab === 'recommend' && (
          <PlaceholderPage 
            icon={<Heart className="w-12 h-12" />}
            title="为你推荐"
            description="根据你的衣橱智能推荐"
          />
        )}
        
        {activeTab === 'profile' && (
          <PlaceholderPage 
            icon={<User className="w-12 h-12" />}
            title="个人中心"
            description="管理你的账户设置"
          />
        )}
      </main>
      
      {/* 底部导航 */}
      <BottomTabs activeTab={activeTab} onTabChange={setActiveTab} />
    </div>
  )
}

// 占位页面组件
function PlaceholderPage({ 
  icon, 
  title, 
  description 
}: { 
  icon: React.ReactNode
  title: string
  description: string
}) {
  return (
    <div className="flex-1 flex flex-col items-center justify-center p-8 text-center">
      <div className="w-24 h-24 rounded-2xl bg-gradient-to-br from-muted to-secondary flex items-center justify-center mb-4 shadow-lg border border-border/60">
        <span className="text-muted-foreground">{icon}</span>
      </div>
      <h2 className="text-xl font-bold text-foreground mb-2">{title}</h2>
      <p className="text-muted-foreground text-sm">{description}</p>
      <p className="text-muted-foreground/60 text-xs mt-4">功能开发中...</p>
    </div>
  )
}
