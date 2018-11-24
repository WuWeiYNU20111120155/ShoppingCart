package com.wuwei.shopping_cart.util;


/*
依赖注入
Statement 是 SQL包里面的一个类，没有办法直接声明称Component,
 需要用工厂模式来生成这个可以注入的依赖对象。

 */

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component("statement")
public class StatementFactory implements FactoryBean<Statement> {

    private static final String DB_PATH = "jdbc:sqlite:resources/sample.db";
    //TODO : put database url in config file


    @Override
    public Statement getObject() throws Exception{
        // 创建数据库链接
        Connection connection = DriverManager.getConnection(DB_PATH);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        return statement;
    }

    @Override
    public Class<?> getObjectType() {
        return Statement.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
