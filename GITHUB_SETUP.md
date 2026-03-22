# 连接到 GitHub 仓库

## 前提条件

1. 确保你有 GitHub 账户（https://github.com）
2. 确保已经安装并配置了 Git
3. 确保当前项目的 git 已经初始化（我们已经完成）

---

## 步骤 1：在 GitHub 上创建新仓库

1. 访问 https://github.com/new
2. 填写仓库信息：
   - **Repository name**: 建议填写 `ootd-app` 或 `wardrobe-management`
   - **Description**: 衣橱管理应用（OOTD - Outfit of the Day）
   - **Visibility**: 选择 Public（公开）或 Private（私有）
3. 点击 **Create repository**

---

## 步骤 2：连接远程仓库

### 方式一：通过 GitHub Desktop（推荐）

1. 下载并安装 GitHub Desktop（https://desktop.github.com/）
2. 打开 GitHub Desktop，选择 "Add an existing repository from your hard drive"
3. 选择项目文件夹 `C:\Users\Falli\AndroidStudioProjects\ootd`
4. 在仓库设置中，点击 "Publish repository"
5. 跟随提示完成发布

### 方式二：通过命令行

在项目根目录打开命令行（Git Bash）：

```bash
# 添加远程仓库（替换为你在 GitHub 上创建的仓库地址）
git remote add origin https://github.com/你的用户名/你的仓库名.git

# 第一次推送
git branch -M main
git push -u origin main
```

---

## 步骤 3：Android Studio 集成

1. 打开 Android Studio
2. 点击顶部菜单 **VCS > Enable Version Control Integration**（如果尚未启用）
3. 选择 Git
4. 在右下角点击 "Git" 标签，或者使用 **View > Tool Windows > Git** 打开 Git 工具窗口
5. 你现在应该能看到所有的代码变更和提交历史

---

## 步骤 4：常用操作

### 提交代码
```bash
# 查看状态
git status

# 添加变更
git add .

# 提交
git commit -m "你的提交信息"

# 推送到远程
git push
```

### 分支管理
```bash
# 创建新分支
git branch feature/新功能名

# 切换分支
git checkout feature/新功能名

# 合并分支（在 main 分支）
git merge feature/新功能名
```

---

## 建议的 .gitignore 文件

项目已包含标准的 Android .gitignore 文件，但你可以根据需要添加：

```gitignore
# IDE 配置
.idea/
*.iml

# 构建输出
build/
*.apk

# 临时文件
*.log
*.tmp

# 敏感信息
*.env
local.properties
```

---

## 连接成功后

连接成功后，你就可以：
- 在 GitHub 上查看项目代码
- 使用 Pull Requests 进行代码审核
- 配置 CI/CD 流程（如 GitHub Actions）
- 备份和协作开发

---

## 如果遇到问题

### 权限问题
如果在 push 时遇到权限错误，可能需要：
1. 检查远程仓库地址是否正确
2. 确保你的 GitHub 账户有访问权限
3. 检查 Git 配置的用户名和邮箱是否正确

### 网络问题
如果网络连接失败，尝试使用 SSH 地址替代 HTTPS：
```bash
git remote set-url origin git@github.com:你的用户名/你的仓库名.git
```

---

## 🚀 现在就开始！

1. 在 GitHub 上创建仓库
2. 连接到本地仓库
3. 推送代码
4. 在 Android Studio 中享受完整的版本控制体验

祝你使用愉快！
