# V0 到 Android 原生页面转换工作流

## 🎯 目标

将 v0.app 生成的 React/Vue/Svelte 前端代码转换为 Jetpack Compose 原生 Android 页面。

---

## 📁 文件夹结构

```
v0/
├── ui/                      # 存放 v0 导出的代码
│   ├── login/              # 登录页面
│   ├── wardrobe/           # 衣橱页面
│   ├── outfit/             # 穿搭页面
│   ├── recommendation/     # 推荐页面
│   └── profile/            # 个人中心页面
└── WORKFLOW.md             # 本工作流文档
```

---

## 🔍 工作流步骤

### 第一步：导出 v0 代码

1. 在 v0.app 中完成页面设计
2. 点击 **Export** 按钮
3. 选择 **React** 或 **Static HTML/CSS** 格式
4. 下载代码包

### 第二步：组织代码到文件夹

1. 解压下载的代码
2. 将登录页面代码放入 `v0/ui/login/`
3. 将衣橱页面代码放入 `v0/ui/wardrobe/`
4. 将穿搭页面代码放入 `v0/ui/outfit/`
5. 将推荐页面代码放入 `v0/ui/recommendation/`
6. 将个人中心页面代码放入 `v0/ui/profile/`

### 第三步：提供页面信息

对于每个页面，提供以下信息：

**文件名格式**（示例）：
```
v0/ui/login/
├── index.html      # 页面结构
├── styles.css      # 样式
├── script.js       # 交互逻辑
└── README.md       # 说明（可选）
```

**必填内容**：
- HTML 文件（页面结构）
- CSS 文件（样式和颜色）
- 简单的功能说明

---

## 📋 页面对应关系

### 1. 登录页面 (`v0/ui/login/`)
- 对应 Android 中的 `SimpleLoginScreen()`
- 需要包含：邮箱输入框、密码输入框、登录按钮

### 2. 衣橱页面 (`v0/ui/wardrobe/`)
- 对应 Android 中的 `SimpleWardrobeScreen()`
- 需要包含：衣物网格/列表、添加衣物按钮

### 3. 穿搭页面 (`v0/ui/outfit/`)
- 对应 Android 中的 `SimpleOutfitScreen()`
- 需要包含：穿搭列表、创建穿搭按钮

### 4. 推荐页面 (`v0/ui/recommendation/`)
- 对应 Android 中的 `SimpleRecommendationScreen()`
- 需要包含：推荐列表、刷新按钮

### 5. 个人中心页面 (`v0/ui/profile/`)
- 对应 Android 中的 `SimpleProfileScreen()`
- 需要包含：用户信息、设置选项、退出登录

---

## 🎨 设计系统转换

### 颜色系统
我会将 v0 中的颜色转换为 Android 的颜色系统：
```kotlin
// 在 Color.kt 中
val Primary = Color(0xFF6200EE)
val Secondary = Color(0xFF03DAC6)
val Background = Color(0xFFFFFFFF)
val Surface = Color(0xFFFFFFFF)
```

### 字体系统
我会将 v0 中的字体转换为 Android 的 Material Design 排版：
```kotlin
// 在 Type.kt 中
val DisplayLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp
)
```

### 组件映射
| v0 组件 | Jetpack Compose 对应组件 |
|---------|-------------------------|
| Button | Button / FilledButton |
| Input | OutlinedTextField |
| Card | Card |
| List | LazyColumn / LazyRow |
| Image | Image + Coil |

---

## 🔄 开发流程

### 阶段 1：代码分析
1. 阅读你提供的 v0 代码
2. 分析页面结构和样式
3. 识别主要组件和功能

### 阶段 2：组件实现
1. 在 Color.kt 和 Type.kt 中定义设计系统
2. 在 MainActivity.kt 中实现各个页面
3. 添加导航和状态管理

### 阶段 3：测试和优化
1. 在 Android Studio 中运行和测试
2. 调整布局和交互
3. 优化性能和用户体验

---

## 📝 提交规则

### 提供 v0 代码时，请遵循以下格式：

**文件名格式**：
```
v0/ui/页面名称/
├── index.html         # 页面结构
├── styles.css         # 样式
├── script.js          # 交互逻辑
└── assets/            # 图片等资源
```

**资源引用**：
- 使用相对路径引用资源
- 确保所有图片和字体资源都是可访问的

**避免的问题**：
- 避免使用复杂的外部依赖
- 避免使用浏览器特定的 API
- 简化交互逻辑，只保留核心功能

---

## 🚀 开始使用

1. 在 v0.app 中设计页面
2. 导出代码并放入对应的文件夹
3. 告诉我你完成了哪些页面
4. 我会在 24 小时内完成转换
5. 在 Android Studio 中测试和验证

---

## 📞 沟通方式

**如何联系我**：
1. 在项目中创建新的 `.claude` 文件
2. 在其中写入你的需求和问题
3. 我会自动识别并处理

**更新流程**：
- 如果你更新了 v0 代码，请覆盖原文件
- 告诉我有哪些变化
- 我会重新转换受影响的页面

---

## 💡 最佳实践

### 简化设计
- 避免过度复杂的布局
- 确保在不同屏幕尺寸上的可读性
- 优先考虑核心功能

### 性能优化
- 使用高效的布局结构
- 优化图片资源
- 避免不必要的重绘

### 可访问性
- 确保文本对比度足够
- 使用语义化的组件
- 支持屏幕阅读器

---

## 🎉 祝你设计愉快！

开始在 v0.app 中创建你梦想的衣橱管理应用 UI 吧！按照本工作流提供代码，我会帮你转换为完美的 Android 原生应用。
