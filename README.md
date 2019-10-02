# BarcodeAPIJava

## API
请参考API.md


## SpringBoot Settings 
* Setting file is: application.properties under resources folder.

### Session
Enable Session by set store-type. 默认采用cookie
````
# Session
spring.session.store-type=jdbc
server.servlet.session.timeout=31536000
````

### Database
* Create the DB tables for Spring session by execute schema-mysql.sql under the resources folder.
* Enable Mysql and connection pool by set store-type 
````
# Datasource
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot
spring.datasource.username=root
spring.datasource.password=root
````

### JPA (Hibernate)
````
spring.jpa.hibernate.ddl-auto=update  # for dev
# spring.jpa.hibernate.ddl-auto=validate # for production
````

### 404 Handling 
To disable the default 404 handling and let our own GlobalExceptionHandler to handle it
````
spring.mvc.throw-exception-if-no-handler-found=true
spring.resources.add-mappings=false
````

### Login validation for each request
* Enable validation by adding LoginInterceptor in InterceptorConfigurer to force validate each request. 
* Each method handler in controller will have this inspector except it has @LoginExempt annotation.
* Use @LoginExempt annotation in controller handler method to skip the login check.

### Exception handler
* APIExceptionHandler is our global exception handler for all exceptions, including 404. 
* Each exception will response a non-200 status code and message/error header . 请参考 API.md for details.


### 关于Model 中的 annotation。 
* @JsonProperty: 输出的json response的字段名与Model的属性名称不一致的时候，给属性取一个别名了。使用： @JsonProperty("new_key_name")
* @JsonIgnore: Do not include in json response.
* @Transient: Do not save to db

### 自定义APIException
* 继承自RuntimeException. 这样的话抛出此异常，@Transactional 才会回滚。

### Map MySQL JSON column to Object
* See https://github.com/vladmihalcea/hibernate-types
* Guide: https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/
* add Gradle dependency in build.gradle
````
compile 'com.vladmihalcea:hibernate-types-52:2.7.0'
````
* Class and Property Example:
````
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@TypeDef(name = "json", typeClass = JsonStringType.class)
public class TeamMember {

    @Type(type = "json")
    @Column(columnDefinition = "json")
    public JsonNode permissions;
}
````

