# API

## Http Request
暂时没有说明

## Http Response

### Http Status Code
````
200: OK
400: 操作失败
401: 需要重新登录
404: 请求的API不存在
500: 服务器内部故障
````

### Http Response Header 
* message 和 error 放在response header中， 采用Base64编码。 
* 如果message存在，客户端弹框显示内容给用户
* 如果header存在，则打印到日志，这是给Developer看的

