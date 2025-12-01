# 构建命令使用指南

本文档介绍如何使用 Gradle 和 Maven 构建本项目。

## 目录

- [Gradle vs Maven 命令对照](#gradle-vs-maven-命令对照)
- [常用 Gradle 命令](#常用-gradle-命令)
- [项目特定命令](#项目特定命令)
- [配置说明](#配置说明)
- [常见问题](#常见问题)

---

## Gradle vs Maven 命令对照

| 功能 | Gradle | Maven |
|------|--------|-------|
| **编译** | `./gradlew compileJava` | `mvn compile` |
| **测试** | `./gradlew test` | `mvn test` |
| **打包** | `./gradlew build` | `mvn package` |
| **清理** | `./gradlew clean` | `mvn clean` |
| **清理并构建** | `./gradlew clean build` | `mvn clean package` |
| **安装到本地仓库** | `./gradlew install` | `mvn install` |
| **发布到仓库** | `./gradlew publish` | `mvn deploy` |
| **跳过测试构建** | `./gradlew build -x test` | `mvn package -DskipTests` |
| **查看依赖** | `./gradlew dependencies` | `mvn dependency:tree` |
| **查看任务** | `./gradlew tasks` | `mvn help:effective-pom` |
| **查看帮助** | `./gradlew help` | `mvn help` |
| **查看项目属性** | `./gradlew properties` | `mvn help:evaluate` |

---

## 常用 Gradle 命令

### 基础构建命令

```bash
# 编译项目
./gradlew compileJava

# 运行测试
./gradlew test

# 构建项目（编译+测试+打包）
./gradlew build

# 清理构建产物
./gradlew clean

# 清理并重新构建
./gradlew clean build
```

### 打包相关命令

```bash
# 生成 JAR 包
./gradlew jar

# 生成源码包
./gradlew sourcesJar

# 生成 Javadoc 包
./gradlew javadocJar

# 生成所有包（JAR + 源码 + Javadoc）
./gradlew build
```

### 发布命令

```bash
# 发布到本地 Maven 仓库
./gradlew publishToMavenLocal

# 发布到配置的远程仓库（需要配置 Nexus 信息）
./gradlew publish

# 发布时跳过测试
./gradlew publish -x test
```

### 查看信息命令

```bash
# 查看所有可用任务
./gradlew tasks

# 查看所有任务（包括隐藏任务）
./gradlew tasks --all

# 查看项目依赖树
./gradlew dependencies

# 查看项目属性
./gradlew properties

# 查看构建信息
./gradlew buildEnvironment
```

---

## 项目特定命令

### 发布到 Nexus 仓库

本项目配置了发布到 Nexus 快照仓库的功能。发布前需要配置以下属性：

#### 方式一：使用命令行参数

```bash
./gradlew publish \
  -PnexusSnapshotsUrl=https://your-nexus-url/repository/snapshots/ \
  -PnexusUsername=your-username \
  -PnexusPassword=your-password
```

#### 方式二：使用 gradle.properties 文件

在项目根目录或用户目录（`~/.gradle/gradle.properties`）创建 `gradle.properties` 文件：

```properties
nexusSnapshotsUrl=https://your-nexus-url/repository/snapshots/
nexusUsername=your-username
nexusPassword=your-password
```

然后直接运行：

```bash
./gradlew publish
```

#### 方式三：使用环境变量

设置环境变量（注意格式）：

```bash
# Windows (PowerShell)
$env:ORG_GRADLE_PROJECT_nexusSnapshotsUrl="https://your-nexus-url/repository/snapshots/"
$env:ORG_GRADLE_PROJECT_nexusUsername="your-username"
$env:ORG_GRADLE_PROJECT_nexusPassword="your-password"

# Linux/Mac
export ORG_GRADLE_PROJECT_nexusSnapshotsUrl="https://your-nexus-url/repository/snapshots/"
export ORG_GRADLE_PROJECT_nexusUsername="your-username"
export ORG_GRADLE_PROJECT_nexusPassword="your-password"
```

---

## 配置说明

### build.gradle 中的配置项

项目在 `build.gradle` 的 `publishing` 块中使用了以下配置：

```groovy
def nexusSnapshotsUrl = project.property("nexusSnapshotsUrl")
def nexusUsername = project.property("nexusUsername")
def nexusPassword = project.property("nexusPassword")
```

这些属性通过 `project.property()` 读取，Gradle 会按以下优先级查找：

1. **命令行参数** (`-PpropertyName=value`) - 最高优先级
2. **项目级 gradle.properties** (`项目根目录/gradle.properties`)
3. **用户级 gradle.properties** (`~/.gradle/gradle.properties`)
4. **环境变量** (`ORG_GRADLE_PROJECT_<属性名>`)

### 项目信息

- **Group ID**: `io.github.zhongzichang`
- **Artifact ID**: `spring-iap`
- **当前版本**: `1.0.2-SNAPSHOT`
- **Java 版本**: 1.8

---

## 常见问题

### Q: 执行 publish 命令时提示找不到属性？

**A**: 需要配置 Nexus 相关属性。可以通过以下方式之一：
- 使用命令行参数 `-P`
- 创建 `gradle.properties` 文件
- 设置环境变量

### Q: 如何跳过测试？

**A**: 使用 `-x test` 参数：
```bash
./gradlew build -x test
./gradlew publish -x test
```

### Q: Windows 系统如何使用 gradlew？

**A**: 使用 `gradlew.bat`：
```cmd
gradlew.bat build
gradlew.bat publish -PnexusSnapshotsUrl=xxx
```

### Q: 如何查看详细的构建日志？

**A**: 使用 `--info` 或 `--debug` 参数：
```bash
./gradlew build --info
./gradlew build --debug
```

### Q: 如何清理 Gradle 缓存？

**A**: 使用以下命令：
```bash
./gradlew cleanBuildCache
# 或者手动删除
rm -rf ~/.gradle/caches
```

---

## 参考资源

- [Gradle 官方文档](https://docs.gradle.org/)
- [Gradle 用户指南](https://docs.gradle.org/current/userguide/userguide.html)
- [Maven vs Gradle 对比](https://www.baeldung.com/gradle-vs-maven)

