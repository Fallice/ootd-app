export interface ClothingItem {
  id: string
  name: string
  category: string
  tags: string[]
  image: string
  color: string
}

export interface Category {
  id: string
  name: string
  icon: string
  count: number
}

export const categories: Category[] = [
  { id: 'all', name: '全部', icon: '👗', count: 24 },
  { id: 'tops', name: '上衣', icon: '👕', count: 8 },
  { id: 'bottoms', name: '下装', icon: '👖', count: 6 },
  { id: 'dresses', name: '连衣裙', icon: '👗', count: 4 },
  { id: 'outerwear', name: '外套', icon: '🧥', count: 3 },
  { id: 'shoes', name: '鞋子', icon: '👟', count: 5 },
  { id: 'bags', name: '包包', icon: '👜', count: 4 },
  { id: 'accessories', name: '配饰', icon: '💍', count: 6 },
]

export const clothingItems: ClothingItem[] = [
  {
    id: '1',
    name: '米白色针织开衫',
    category: 'tops',
    tags: ['休闲', '春秋'],
    image: '/clothes/cardigan.jpg',
    color: '#F5F5DC'
  },
  {
    id: '2',
    name: '深蓝色牛仔裤',
    category: 'bottoms',
    tags: ['百搭', '日常'],
    image: '/clothes/jeans.jpg',
    color: '#1E3A5F'
  },
  {
    id: '3',
    name: '碎花连衣裙',
    category: 'dresses',
    tags: ['优雅', '夏季'],
    image: '/clothes/floral-dress.jpg',
    color: '#FFB6C1'
  },
  {
    id: '4',
    name: '卡其色风衣',
    category: 'outerwear',
    tags: ['经典', '秋冬'],
    image: '/clothes/trench.jpg',
    color: '#C3B091'
  },
  {
    id: '5',
    name: '白色运动鞋',
    category: 'shoes',
    tags: ['运动', '百搭'],
    image: '/clothes/sneakers.jpg',
    color: '#FFFFFF'
  },
  {
    id: '6',
    name: '棕色托特包',
    category: 'bags',
    tags: ['通勤', '大容量'],
    image: '/clothes/tote.jpg',
    color: '#8B4513'
  },
  {
    id: '7',
    name: '灰色毛衣',
    category: 'tops',
    tags: ['保暖', '秋冬'],
    image: '/clothes/sweater.jpg',
    color: '#808080'
  },
  {
    id: '8',
    name: '黑色西装裤',
    category: 'bottoms',
    tags: ['正式', '通勤'],
    image: '/clothes/slacks.jpg',
    color: '#2D2D2D'
  },
  {
    id: '9',
    name: '粉色衬衫',
    category: 'tops',
    tags: ['甜美', '春季'],
    image: '/clothes/blouse.jpg',
    color: '#FFB6C1'
  },
  {
    id: '10',
    name: '格纹半裙',
    category: 'bottoms',
    tags: ['复古', '秋冬'],
    image: '/clothes/plaid-skirt.jpg',
    color: '#8B0000'
  },
  {
    id: '11',
    name: '黑色高跟鞋',
    category: 'shoes',
    tags: ['正式', '优雅'],
    image: '/clothes/heels.jpg',
    color: '#1A1A1A'
  },
  {
    id: '12',
    name: '珍珠项链',
    category: 'accessories',
    tags: ['优雅', '百搭'],
    image: '/clothes/necklace.jpg',
    color: '#FFFAF0'
  },
]
