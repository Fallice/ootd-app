# OOTD - 衣橱管理应用

一款智能衣橱管理应用，帮助用户管理衣物、创建穿搭组合，并获取个性化穿搭推荐。

## 功能模块

### 1. 用户管理
- 用户注册/登录（邮箱/手机号）
- 用户认证与授权（JWT Token）
- 用户资料管理（身高、体重、体型、风格偏好）
- 密码重置与账户安全

### 2. 衣橱管理
- 衣物上传（拍照/从相册选择）
- 衣物自动识别（AI 识别类型、颜色、材质等）
- 衣物分类管理（按类型、季节、颜色等）
- 衣物详情编辑（名称、价格、购买日期等）
- 衣物搜索与筛选
- 衣橱统计与分析

### 3. 穿搭组合
- 自动穿搭生成（基于 AI 推荐算法）
- 手动穿搭组合（用户自由搭配）
- 穿搭图上传与识别（AI 识别穿搭中的衣物）
- 穿搭保存与管理（收藏、删除、分享）
- 穿搭季节与场合标签
- 穿搭效果预览

### 4. 推荐系统
- 个性化穿搭推荐（基于用户喜好和衣橱内容）
- 热门穿搭推荐（其他用户上传）
- 系统内置推荐（季节、场合主题）
- 推荐内容筛选与排序
- 推荐理由说明

### 5. 个人中心
- 用户账户信息（头像、昵称、邮箱等）
- 个人资料管理（身高、体重、体型、风格）
- 偏好设置（通知、隐私、主题）
- 使用统计（上传数量、穿搭次数、收藏数）
- 帮助与反馈
- 关于应用

## 技术栈

### 前端
- **UI 框架**: Jetpack Compose
- **语言**: Kotlin
- **架构**: MVVM + Repository Pattern
- **状态管理**: StateFlow + ViewModel

### 后端建议
- **框架**: Spring Boot / Node.js
- **数据库**: PostgreSQL / MySQL
- **缓存**: Redis
- **AI 服务**: Claude API / OpenAI API

### 核心依赖
- **网络请求**: Retrofit + OkHttp
- **图片加载**: Coil
- **数据存储**: Room + DataStore
- **导航**: Navigation Compose

## 项目结构

```
app/src/main/java/com/fallice/ootd/
├── App.kt                          # 应用主入口
├── MainActivity.kt                 # 主 Activity
├── data/
│   ├── models/                     # 数据模型
│   │   ├── User.kt
│   │   ├── Clothing.kt
│   │   ├── Outfit.kt
│   │   └── Recommendation.kt
│   ├── network/                    # 网络层
│   │   ├── ApiClient.kt
│   │   ├── ApiConstants.kt
│   │   ├── ApiResponse.kt
│   │   └── ApiService.kt
│   ├── database/                   # 数据库层
│   └── repositories/               # 数据仓库
│       ├── UserRepository.kt
│       ├── ClothingRepository.kt
│       ├── OutfitRepository.kt
│       └── RecommendationRepository.kt
├── ui/                             # UI 层
│   ├── auth/                       # 认证模块
│   │   ├── LoginScreen.kt
│   │   └── RegisterScreen.kt
│   ├── wardrobe/                   # 衣橱模块
│   │   └── WardrobeScreen.kt
│   ├── outfit/                     # 穿搭模块
│   │   └── OutfitScreen.kt
│   ├── recommendation/             # 推荐模块
│   │   └── RecommendationScreen.kt
│   ├── profile/                    # 个人中心模块
│   │   └── ProfileScreen.kt
│   └── theme/                      # 主题
├── viewmodels/                     # ViewModel
│   ├── AuthViewModel.kt
│   ├── WardrobeViewModel.kt
│   ├── OutfitViewModel.kt
│   └── RecommendationViewModel.kt
└── utils/                          # 工具类
    └── Navigation.kt
```

## 数据模型设计

### User (用户)
- 基本信息：用户名、邮箱、昵称、头像
- 身体数据：身高、体重、体型
- 风格偏好：喜欢的穿搭风格

### Clothing (衣物)
- 基本信息：名称、图片、类型、子类型
- 属性：颜色、材质、季节、场合、尺寸
- 其他：品牌、价格、购买日期、是否收藏

### Outfit (穿搭)
- 基本信息：标题、描述、图片
- 标签：季节、场合、风格、天气标签
- 互动数据：点赞数、浏览数
- 关联：包含的衣物列表

### Recommendation (推荐)
- 穿搭信息：关联的穿搭
- 推荐数据：推荐类型、评分、推荐理由

## API 设计概要

### 认证接口
- `POST /api/auth/login` - 用户登录
- `POST /api/auth/register` - 用户注册
- `POST /api/auth/refresh-token` - 刷新 Token

### 衣橱接口
- `GET /api/clothes` - 获取衣物列表
- `POST /api/clothes` - 添加衣物
- `GET /api/clothes/:id` - 获取衣物详情
- `PUT /api/clothes/:id` - 更新衣物
- `DELETE /api/clothes/:id` - 删除衣物
- `POST /api/clothes/:id/identify` - 识别衣物信息

### 穿搭接口
- `GET /api/outfits` - 获取穿搭列表
- `POST /api/outfits` - 创建穿搭
- `GET /api/outfits/:id` - 获取穿搭详情
- `PUT /api/outfits/:id` - 更新穿搭
- `DELETE /api/outfits/:id` - 删除穿搭
- `POST /api/outfits/generate` - 生成穿搭
- `POST /api/outfits/identify` - 识别穿搭图

### 推荐接口
- `GET /api/recommendations` - 获取推荐列表
- `GET /api/recommendations/popular` - 获取热门推荐
- `GET /api/recommendations/trending` - 获取趋势推荐
- `POST /api/recommendations/feedback` - 推荐反馈

## AI 大模型集成

### 衣物识别
使用 Claude API 分析衣物图片，自动识别：
- 衣物类型（上衣、下装、连衣裙等）
- 颜色
- 材质
- 适用季节
- 适用场合
- 风格标签

### 穿搭推荐
基于以下因素生成个性化穿搭：
- 用户的衣橱内容
- 用户的风格偏好
- 用户的体型数据
- 当前季节和天气
- 特定场合需求
- 时尚趋势

### 穿搭评分
对用户创建的穿搭进行分析：
- 色彩搭配协调性
- 风格一致性
- 场合适配度
- 改进建议

## 使用说明

### 环境配置
1. 在 `ApiConstants.kt` 中配置后端 API 地址
2. 配置网络安全策略（如果需要 HTTP）

### 开发说明
- 应用采用单 Activity 多 Compose 页面架构
- 使用 MVVM + Repository 模式进行架构设计
- StateFlow 用于状态管理和数据流传递

### 注意事项
- 网络请求在 IO 线程执行
- UI 状态在主线程更新
- 使用 ViewModel 管理生命周期
- 注意内存泄漏和资源释放

## 下一步计划

### 短期
- 完善细节页面的实现
- 添加相机和图片选择功能
- 实现本地数据库缓存
- 添加用户引导和帮助文档

### 中期
- 优化推荐算法
- 添加社交功能（关注、评论等）
- 实现数据同步策略
- 性能优化和错误处理完善

### 长期
- 开发 Web 版本
- 集成更多 AI 功能
- 添加电商链接
- 开发数据分析和报告功能

## 许可证

MIT License
