# java实现跨域SSO单点登录 springboot + SSO + JWT

### 什么是SSO
SSO（Single Sign On）单点登录是实现多个系统之间统一登录的验证系统，简单来说就是：有A，B，C三个系统，在A处登录过后，再访问B系统，B系统就已经处于了登录状态，C系统也是一样。举个生活中栗子：你同时打开天猫和淘宝，都进入login界面，都要求你登录的，现在你在淘宝处登录后，直接在天猫处刷新，你会发现，你已经登录了，而且就是你在淘宝上登录的用户。说明他们实现了SSO，并且持有相同的信息。

当然这个特性意味着它的使用场景是：同一公司下的不同子系统，因为对于SSO来说，每一个子系统拥有的信息都一样，是用户的全部信息，如果是不同公司，那这肯定不合适。现在的天猫和淘宝就是这样的一套SSO。

### 实现思想
SSO简单来说就是一句话：一处登录，全部访问。
现在有两个系统分别是：a.com和b.com，我们要实现他们的SSO，那么我们就需要一个统一验证中心sso.com，我们所有的登录和身份验证都在sso.com中操作。看图看传统登录方式和SSO方式的差别如下：
![](http://tuchuang.aitangbao.com.cn/sso3.png)

我们需要将统一信息存在cookie中。
### 登录部分：
在用户第一次访问a.com时，到达a.com的服务器，服务器请求sso.com/ssocheck验证，验证失败，a.com的服务器到达login界面，用户在login界面输入用户名和密码，到达a.com的服务器，请求sso.com/login验证，验证通过生成token（包括用户登录信息），然后携带token和所有子系统路径返回a.com的服务器，a.com的服务器到达首页，同时请求自己和所有子系统的addcookie方法，将token添加到自己的cookie中。
在用户访问b.com时，同样向sso.com/check发出验证cookie请求，sso验证token，验证成功返回到b.com的服务器，然后到达b的首页显示登录成功。

### 退出部分：
用户点击a.com的退出按钮，访问sso.com/loginout，然后获得所有子系统信息，请求所有子系统clearcookie方法，并重定向到login界面。

### 跨域部分：我使用的是ajax的jsonp方式。
看下登录（退出就不看了，登录写出来后退出就很简单了）的流程图：
![](http://tuchuang.aitangbao.com.cn/sso4.png)


### 项目使用
1.执行test下的sql脚本，配置数据库连接  
2.启动两个项目， 一个端口8080,8081  
3.访问localhost:8080, 用户名admin，密码admin， 登陆  
4.访问localhost:8081/ssocheck 惊喜等待你！  
5.实际项目中， 可使用拦截器获取cookie进行校验

## License
纯粹开源分享，感谢大家 [Star](https://github.com/aitangbao/springboot-jwt-sso) 的支持。