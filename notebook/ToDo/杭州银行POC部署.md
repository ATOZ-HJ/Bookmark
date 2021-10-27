### 新建用户

```
useradd ksquant
groupadd docker
usermod -aG docker ksquant
passwd ksquant
# 设置密码 ksquant

su - ksquant
cd /home/ksquant
```



### 上传文件

1. 上传deploy.zip ，到 /home/ksquant 目录
2. 解压

```shell
unzip deploy.zip
```





### Docker安装

```shell
cd /home/ksquant/docker/docker-rpm
```

切换到root用户

```shell
su
```

执行命令安装docker(需要使用root权限)

```shell
rpm -ivh *.rpm --nodeps --force
```

修改 daemon.json文件（此为修改镜像仓库地址，演示、生产环境部署时不需要配置）

```shell
vi /etc/docker/daemon.json
```

输入一下内容

```shell
{
 "registry-mirrors": ["https://4s5a1mbp.mirror.aliyuncs.com"],
 "insecure-registries":["hub.kingstarfintech.com"]
}

```

启动docker

```shell
sudo systemctl enable docker
sudo systemctl start docker
```

将可执行权限应用于二进制文件

```shell
sudo mv /home/ksquant/docker/docker-compose/docker-compose /usr/local/bin/docker-compose
```

```shell
sudo chmod +x /usr/local/bin/docker-compose
```

测试安装的docker 信息

```shell
docker info
```

测试安装的docker-compose

```shell
docker-compose --version
```

创建docker网络

```shell
docker network create  --gateway 172.16.1.1 --subnet 172.16.1.0/24 app
```

查看创建的app网络

```shell
docker network ls
```





### 导入镜像

```shell
cd /home/ksquant/mirrors
docker load -i mysql.tar
docker load -i jdk.tar
docker load -i nginx.tar
docker load -i cmbfactor_server.tar
docker load -i ks_jupyter.tar
docker load -i mongo.tar
# docker load -i quot_sub.tar
```





###  MySQL部署

```shell
docker run -p 3306:3306  --restart=always -e TZ=Asia/Shanghai  --privileged=true   -v=/home/ksquant/mysql/conf/my.cnf:/etc/my.cnf -v=/home/ksquant/mysql/data:/var/lib/mysql -v=/home/ksquant/mysql/log:/var/log/mysql --name mysql -e MYSQL_ROOT_PASSWORD=kingstar123456 -d mysql:5.7
```



### 初始化SQL脚本

#### java端

```shell
cd /home/ksquant/sql/qtserver
cp *.sql /home/ksquant/mysql/data/qtserver
docker exec -it mysql bash
mysql -u root -p
# 密码
kingstar123456
# 创建数据库
source /var/lib/mysql/qtserver/createDatabase.sql
use ks_quant
# 创建表
source /var/lib/mysql/qtserver/createTables.sql
# 初始化数据
source /var/lib/mysql/qtserver/initBaseData.sql
```

#### 行情中心

```shell
cd /home/ksquant/sql/quotation
cp *.sql /home/ksquant/mysql/data/quotation
docker exec -it mysql bash
mysql -u root -p
# 密码
kingstar123456
# 创建数据库
source /var/lib/mysql/quotation/createDatabase.sql
use quotation_test
# 创建表
source /var/lib/mysql/quotation/createTables.sql
# 初始化数据
source /var/lib/mysql/quotation/initBaseData.sql
```





### nginx部署

```shell
mkdir -p /home/ksquant/nginx/html
mkdir -p /home/ksquant/nginx/config
mkdir -p /home/ksquant/nginx/logs
cd /home/ksquant/nginx/config
vi default.conf # 编辑配置文件
```

配置文件内容

```
server {
    listen       80;
    listen  [::]:80;
    server_name  localhost;
    client_max_body_size   10m;
    #charset koi8-r;
    #access_log  /var/log/nginx/host.access.log  main;

   location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    }

   location /data {
        root /usr/share/nginx/html;
   }

     location /quant {
      root /usr/share/nginx/html;
      index index.html index.htm;
    }

    location /entry {
       proxy_pass http://10.253.49.103:9030/;  #需要修改为Java后台服务的地址信息
    }
    
    


    #error_page  404              /404.html;

    # redirect server error pages to the static page /50x.html
    #
    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }

    # proxy the PHP scripts to Apache listening on 127.0.0.1:80
    #
    #location ~ \.php$ {
    #    proxy_pass   http://127.0.0.1;
    #}

    # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
    #
    #location ~ \.php$ {
    #    root           html;
    #    fastcgi_pass   127.0.0.1:9000;
    #    fastcgi_index  index.php;
    #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
    #    include        fastcgi_params;
    #}

    # deny access to .htaccess files, if Apache's document root
    # concurs with nginx's one
    #
    #location ~ /\.ht {
    #    deny  all;
    #}
}


```

启动nginx

```shell
docker run  -p 80:80 --restart=always   --privileged=true  --name nginx  -v /home/ksquant/nginx/html:/usr/share/nginx/html  -v /home/ksquant/nginx/config/:/etc/nginx/conf.d/ -v  /home/ksquant/nginx/logs:/var/log/nginx/  -d nginx
```



### mongo部署

```shell
#启动mongo
docker run -d  --name mymg -v /home/ksquant/mongo:/data/db  -d -p 27027:27017 mongo mongod
#修改配置
docker exec -it mymg bash
>mongo
>>use admin
>>db.createUser({user: 'root', pwd: '123456', roles: ['root']})
exit
exit
docker stop mymg
docker rm mymg
docker run -d  --name mymg -v /home/ksquant/mongo:/data/db  -d -p 27027:27017 mongo mongod --auth
```







### 行情中心部署

```shell
cd /home/ksquant/quotation
 # 修改配置文件，MySQL配置
vi config.yaml 
# 赋权
chmod  +x main_linuxsge89 
nohup ./main_linuxsge89 &
```



### python端部署

#### 解析代码

```shell
cd /home/ksquant/qtengine 
# 解压python端代码
tar -zxvf  jupyter.tar.gz  
tar -zxvf  lego_quant_platform.tar.gz 
```

#### quot_sub

- 路径

  lego_quant_platform/quot_sub/conf

- 修改点

  配置redis服务ip,端口,密码

  ```
  10.253.49.31,6379,redis
  ```


#### ks_jupyter

- 路径

  ```
  vi /home/ksquant/qtengine/jupyter/kslib/conf
  ```

- 修改点

  配置量化服务的URL

  ```
  http://yourip:8090
  ```


#### cmbfactor_server

- 修改配置文件

  ```
  vi /home/ksquant/qtengine/lego_quant_platform/modules_src/config/config.yaml
  ```

- 修改点

  ```yaml
  #************************
  mongo:
      ip: "10.253.49.103"
      post: "27027"
      user: "root"
      password: "123456"
  
  #模拟实盘gateway名称
  gateway:
      gatewayname: "redis"
  
  #**************回测行情数据地址
  数据地址:
      url: "http://10.253.49.103:10010/cmds/v1/bond/minute?source="
  
  
  #*************模拟实盘行情订阅地址
  行情地址:
      ip: "10.253.49.103"
      post: "10010"
      url: "/sgequotation/v1/add/subscribe"
  
  # 模拟实盘模拟撮合地址
  交易地址:
      ip: "10.253.49.103"
      post: "8080"
  
  # 模拟实盘日志发送地址
  pulsar:
      ip: "58.246.232.52"
      post: "7788"
      logtopic: "export"
  
  runlog:
      loglevel: "1"
      path: "log"
  
  #*********** redis ip:端口,密码
  redis:
      url: "10.253.49.101:6379:redis4588"
  
  #************* 行情推送中心 ip:端口
  quot_sub_server:
      url: "10.253.49.103:19999"
  ```

#### 手动启动

```shell
#启动jupyter
docker run  -d --name myjb -v /home/ksquant/qtengine/jupyter/workdir:/root/datas -v /home/ksquant/qtengine/jupyter/kslib:/root/kslib -p 8963:8963 ks_jupyter
```

```shell
#启动mongo
docker run -d  --name mymg -v /home/ksquant/mongo:/data/db  -d -p 27027:27017 mongo mongod
#修改配置
docker exec -it mymg bash
>mongo
>>use admin
>>db.createUser({user: 'root', pwd: '123456', roles: ['root']})
docker stop mymg
docker rm mymg
docker run -d  --name mymg -v /home/ksquant/mongo:/data/db  -d -p 27027:27017 mongo mongod --auth

```

```shell
#启动PY
 docker run  -d --name mybs -v /home/ksquant/qtengine/lego_quant_platform/modules_src/vnpy/:/vnpy/ -v /home/ksquant/qtengine/lego_quant_platform/modules_src/Server/:/Server -v /home/ksquant/qtengine/lego_quant_platform/modules_src/config:/config -p 8090:8080 -p 9999:9999 cmbfactor_server
```





### Java端部署

```shell
# 修改配置文件 数据库，行情中心，py端等连接信息，jar包操作
cd /home/ksquant/qtserver
docker-compose -f docker-compose.yml up -d
```





### 前端页面

1. 修改静态文件中 jupyter 请求地址，以及docs的请求地址
2. docs目录打包部署

```shell
cd /home/ksquant/page
cp quant-test.tar.gz /home/ksquant/nginx/html/
cp docs.zip /home/ksquant/nginx/html/
cd /home/ksquant/nginx/html/
tar -zxvf quant-test.tar.gz
unzip docs.zip 
mv quant-test quant
```





