### docker用户组权限相关

使用当前用户docker run或者 docker ps 等命令，显示如下错误

```
docker: Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Post http://%2Fvar%2Frun%2Fdocker.sock/v1.24/containers/create: dial unix /var/run/docker.sock: connect: permission denied.
```

1. 将当前用户ksquant加入到docker用户组下

```
usermod -aG docker ksquant
```

2. 执行1 步骤后仍然不生效，执行以下命令

```
sudo chmod 666 /var/run/docker.sock
```

*chmod 666 means that all users can read and write but cannot execute*