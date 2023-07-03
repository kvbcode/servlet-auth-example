package com.cyber.web;

import com.cyber.web.entity.UserDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(port);
        registerUsers(tomcat, loadUsers("users.json"));

        registerWebAppModule(tomcat, "/jakarta-annotations", "jakarta-annotations");
        registerWebAppModule(tomcat, "/jsecuritycheck-webxml", "jsecuritycheck-webxml");

        tomcat.start();
        tomcat.getServer().await();
    }

    private static void registerWebAppModule(Tomcat tomcat, String contextPath, String moduleName) {
        String webappDir = moduleName + "/src/main/webapp/";
        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, new File(webappDir).getAbsolutePath());
        context.addWelcomeFile("index.jsp");

        File webInfClassesPath = new File(moduleName + "/target/classes");
        WebResourceRoot webResourceRoot = new StandardRoot(context);
        DirResourceSet dirResourceSet = new DirResourceSet(webResourceRoot, "/WEB-INF/classes", webInfClassesPath.getAbsolutePath(), "/");
        webResourceRoot.addPreResources(dirResourceSet);
        context.setResources(webResourceRoot);
    }

    private static List<UserDetails> loadUsers(String resource) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStreamReader inputStreamReader = new InputStreamReader(contextClassLoader.getResourceAsStream(resource))) {
            Gson gson = new Gson();
            return gson.fromJson(inputStreamReader, new TypeToken<>() {
            });
        }
    }

    private static void registerUsers(Tomcat tomcat, List<UserDetails> users) {
        for (UserDetails user : users) {
            tomcat.addUser(user.getName(), user.getPassword());
            for (String role : user.getRoles()) {
                tomcat.addRole(user.getName(), role);
            }
        }
    }
}
