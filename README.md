# GitHub API 反向代理

一个基于[LeanCloud](https://leancloud.cn/)云引擎的GitHub API反向代理，用于解决GitHub域名没有备案的问题。

## 部署步骤

+ 安装LeanCloud命令行工具

参照[命令行工具 CLI 使用指南](https://leancloud.cn/docs/leanengine_cli.html)安装命令行工具，并在命令行工具中登录。

+ clone本项目到本地

```bash
git clone https://github.com/boris1993/github-api-reverse-proxy.git
```

+ 将该项目关联至你的云引擎

进入项目根目录，执行`lean switch`命令

```bash
$ lean switch
[INFO] Retrieve app list ...
[?] Please select an app:
 1) your_app_name
 => 1
Switching to app: your_app_name, group: web
```

+ 部署至云引擎

```bash
lean deploy
```

+ 配置云引擎域名

进入LeanCloud控制面板，在`云引擎 -> 设置 --> Web主机域名`中设定域名

## 开源许可

该项目使用[MIT](LICENSE.txt)许可证开放源代码

## 感谢

本项目核心功能使用[mitre/HTTP-Proxy-Servlet](https://github.com/mitre/HTTP-Proxy-Servlet)实现
