package com.netease.user.generator.config;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;

import java.util.List;

/**
 * @author hzyouzhihao on 2016/6/5.
 * 深度定制mybatis-generator,集成自动分页功能
 */
public class CustomPluginAdapter extends PluginAdapter {

    final private FullyQualifiedJavaType pageParamType = new FullyQualifiedJavaType(ConfigUtil.getString("page.param.class"));

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }


    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //集成分页
        if (ConfigUtil.getBoolean("page.param.switch")) {
            Field pageParam = new Field();
            pageParam.setName("pageParam");
            pageParam.setType(pageParamType);
            pageParam.setVisibility(JavaVisibility.PRIVATE);
            topLevelClass.addField(pageParam);
            Method setPageParam = new Method();
            setPageParam.setName("setPageParam");
            setPageParam.addParameter(new Parameter(pageParamType, "pageParam"));
            setPageParam.addBodyLine("this.pageParam=pageParam;");
            setPageParam.setVisibility(JavaVisibility.PUBLIC);
            topLevelClass.addMethod(setPageParam);
            Method getBasePageAO = new Method();
            getBasePageAO.setName("getPageParam");
            getBasePageAO.setReturnType(pageParamType);
            getBasePageAO.addBodyLine("return pageParam;");
            getBasePageAO.setVisibility(JavaVisibility.PUBLIC);
            topLevelClass.addMethod(getBasePageAO);
            topLevelClass.addImportedType(pageParamType);
            List<Method> methods = topLevelClass.getMethods();
            for (Method method : methods) {
                if ("clear".equals(method.getName())) {
                    method.addBodyLine("pageParam = null;");
                }
            }
        }

        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if (ConfigUtil.getBoolean("page.param.switch")) {
            XmlElement ifElment = new XmlElement("if");
            ifElment.addAttribute(new Attribute("test", "pageParam != null"));
            ifElment.addElement(new TextElement("limit #{pageParam.offset},#{pageParam.size} "));
            element.addElement(ifElment);
        }
        return true;
    }
}
