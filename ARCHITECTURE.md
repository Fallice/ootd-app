# 衣橱管理应用架构设计

## 项目概述
衣橱管理应用（OOTD - Outfit of the Day）是一个帮助用户管理衣橱、创建穿搭组合并获取个性化穿搭推荐的移动应用。应用集成了 AI 大模型技术，支持衣物自动识别、穿搭智能推荐等功能。

## 技术栈
- **前端框架**: Jetpack Compose (Android)
- **后端框架**: Spring Boot/Node.js (建议)
- **数据库**: PostgreSQL/MySQL + Redis
- **AI 大模型**: Claude API/OpenAI API
- **图片处理**: Coil (图片加载), ML Kit (图像识别)
- **网络请求**: Retrofit + OkHttp
- **状态管理**: ViewModel + StateFlow

## 应用架构

### 整体架构图
```
┌──────────────────────────────────────────────────────────────────┐
│                        移动应用层                                  │
├──────────────────────────────────────────────────────────────────┤
│ UI 层 (Compose)          │ 数据层 (Room)  │ 网络层 (Retrofit)      │
│ ├─ 登录/注册            │  ├─ 本地缓存    │  ├─ API 接口           │
│ ├─ 衣橱管理            │  ├─ 数据库      │  ├─ 数据同步          │
│ ├─ 穿搭组合            │                │  ├─ 文件上传          │
│ ├─ 推荐                │                │                        │
│ ├─ 个人中心            │                │                        │
└────────────────┬──────┴──────────────┬──┴────────────────────────┘
                 │                     │
                 ▼                     ▼
┌──────────────────────────────────────────────────────────────────┐
│                        服务端层                                    │
├──────────────────────────────────────────────────────────────────┤
│ API 网关               │ 业务服务层       │ 数据持久化层            │
│ ├─ 请求路由            │  ├─ 用户管理     │  ├─ 关系型数据库       │
│ ├─ 权限验证            │  ├─ 衣橱管理     │  ├─ 文件存储          │
│ ├─ 限流熔断            │  ├─ 穿搭管理     │  ├─ 缓存             │
│                        │  ├─ 推荐引擎     │  ├─ 搜索引擎          │
│                        │  ├─ AI 服务集成 │                        │
└────────────────┬──────┴──────────────┬──┴────────────────────────┘
                 │                     │
                 ▼                     ▼
┌──────────────────────────────────────────────────────────────────┐
│                        外部服务层                                  │
├──────────────────────────────────────────────────────────────────┤
│ AI 大模型服务          │ 文件存储服务    │ 通知服务                │
│ ├─ Claude API         │  ├─ 阿里云 OSS   │  ├─ 邮件通知           │
│ ├─ OpenAI API         │  ├─ 腾讯云 COS   │  ├─ 推送通知           │
│ ├─ 图像识别服务        │                │                        │
│ ├─ 自然语言处理        │                │                        │
└──────────────────────────────────────────────────────────────────┘
```

## 核心功能模块

### 1. 用户管理模块
- 用户注册/登录（邮箱/手机号/第三方登录）
- 用户认证与授权（JWT Token）
- 用户资料管理（身高、体重、体型、风格偏好）
- 密码重置与账户安全

### 2. 衣橱管理模块
- 衣物上传（拍照/从相册选择）
- 衣物自动识别（AI 识别类型、颜色、材质等）
- 衣物分类管理（按类型、季节、颜色等）
- 衣物详情编辑（名称、价格、购买日期等）
- 衣物搜索与筛选
- 衣橱统计与分析

### 3. 穿搭组合模块
- 自动穿搭生成（基于 AI 推荐算法）
- 手动穿搭组合（用户自由搭配）
- 穿搭图上传与识别（AI 识别穿搭中的衣物）
- 穿搭保存与管理（收藏、删除、分享）
- 穿搭季节与场合标签
- 穿搭效果预览

### 4. 推荐模块
- 个性化穿搭推荐（基于用户喜好和衣橱内容）
- 热门穿搭推荐（其他用户上传）
- 系统内置推荐（季节、场合主题）
- 推荐内容筛选与排序
- 推荐理由说明

### 5. 个人中心模块
- 用户账户信息（头像、昵称、邮箱等）
- 个人资料管理（身高、体重、体型、风格）
- 偏好设置（通知、隐私、主题）
- 使用统计（上传数量、穿搭次数、收藏数）
- 帮助与反馈
- 关于应用

## 数据模型设计

### 用户表 (users)
```sql
CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(255),
    nickname VARCHAR(50),
    gender VARCHAR(10),
    height INTEGER,
    weight INTEGER,
    body_type VARCHAR(50),
    style_preferences TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### 衣物表 (clothes)
```sql
CREATE TABLE clothes (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    image_url VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    subtype VARCHAR(50),
    color VARCHAR(50),
    material VARCHAR(50),
    season VARCHAR(50),
    occasion VARCHAR(50),
    price DECIMAL(10, 2),
    purchase_date DATE,
    brand VARCHAR(100),
    size VARCHAR(20),
    description TEXT,
    is_favorite BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### 穿搭表 (outfits)
```sql
CREATE TABLE outfits (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    title VARCHAR(100) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    season VARCHAR(50),
    occasion VARCHAR(50),
    style VARCHAR(50),
    weather_tags TEXT,
    is_public BOOLEAN DEFAULT TRUE,
    likes_count INTEGER DEFAULT 0,
    views_count INTEGER DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### 穿搭衣物关联表 (outfit_clothes)
```sql
CREATE TABLE outfit_clothes (
    id UUID PRIMARY KEY,
    outfit_id UUID NOT NULL REFERENCES outfits(id),
    clothes_id UUID NOT NULL REFERENCES clothes(id),
    position VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### 收藏表 (favorites)
```sql
CREATE TABLE favorites (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    type VARCHAR(20) NOT NULL, -- clothes/outfit
    target_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

## API 设计

### 用户管理接口
- `POST /api/auth/register` - 用户注册
- `POST /api/auth/login` - 用户登录
- `POST /api/auth/refresh-token` - 刷新 Token
- `GET /api/users/me` - 获取当前用户信息
- `PUT /api/users/me` - 更新用户信息
- `PUT /api/users/me/preferences` - 更新用户偏好
- `PUT /api/users/me/avatar` - 上传头像

### 衣橱管理接口
- `GET /api/clothes` - 获取用户衣橱列表
- `POST /api/clothes` - 添加衣物
- `GET /api/clothes/:id` - 获取衣物详情
- `PUT /api/clothes/:id` - 更新衣物信息
- `DELETE /api/clothes/:id` - 删除衣物
- `POST /api/clothes/:id/identify` - 自动识别衣物信息
- `GET /api/clothes/search` - 搜索衣物
- `GET /api/clothes/statistics` - 获取衣橱统计信息

### 穿搭管理接口
- `GET /api/outfits` - 获取用户穿搭列表
- `POST /api/outfits` - 创建穿搭
- `GET /api/outfits/:id` - 获取穿搭详情
- `PUT /api/outfits/:id` - 更新穿搭
- `DELETE /api/outfits/:id` - 删除穿搭
- `POST /api/outfits/generate` - 自动生成穿搭
- `POST /api/outfits/identify` - 识别穿搭图中的衣物
- `POST /api/outfits/:id/like` - 点赞/取消点赞

### 推荐接口
- `GET /api/recommendations` - 获取推荐列表
- `GET /api/recommendations/popular` - 获取热门穿搭
- `GET /api/recommendations/trending` - 获取趋势穿搭
- `GET /api/recommendations/seasonal` - 获取季节穿搭
- `POST /api/recommendations/feedback` - 推荐反馈

### 文件上传接口
- `POST /api/upload/image` - 上传图片
- `POST /api/upload/file` - 上传文件

## 安全设计

### 身份验证
- 使用 JWT (JSON Web Token) 进行身份验证
- 支持 Refresh Token 刷新机制
- 密码加密存储 (BCrypt)

### 授权控制
- 基于角色的访问控制 (RBAC)
- API 接口权限验证
- 文件访问权限控制

### 数据安全
- 数据传输加密 (HTTPS)
- 敏感数据加密存储
- SQL 注入防护
- XSS 攻击防护

### 防刷机制
- API 限流 (Rate Limiting)
- 请求频率控制
- 验证码机制

## AI 大模型集成

### 衣物识别
- 使用 Claude API 进行图像分析
- 识别衣物类型、颜色、材质、季节、风格等
- 返回结构化的衣物信息

### 穿搭推荐
- 基于用户的衣橱内容和风格偏好
- 结合天气、场合、季节等因素
- 使用 AI 生成个性化穿搭建议

### 穿搭评分
- 对用户创建的穿搭进行评分和建议
- 分析穿搭的协调性、搭配合理性
- 提供改进建议

## 部署架构

### 开发环境
- 本地开发服务器
- Android 模拟器
- 本地数据库 (H2/MySQL)

### 测试环境
- 测试服务器集群
- 自动化测试
- 性能测试

### 生产环境
- 容器化部署 (Docker + Kubernetes)
- 负载均衡
- 监控与日志
- 自动扩缩容

## 扩展计划

### 短期计划 (1-3 个月)
- 完成核心功能开发
- 优化用户体验
- 修复已知 bug
- 完善测试用例

### 中期计划 (3-6 个月)
- 集成更多第三方服务
- 优化推荐算法
- 开发社交功能
- 支持多语言

### 长期计划 (6-12 个月)
- 开发 iOS 版本
- 增强 AI 功能
- 开发 Web 版本
- 扩展商业化功能
