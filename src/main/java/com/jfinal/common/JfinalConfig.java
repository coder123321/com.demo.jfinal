package com.jfinal.common;

import com.jfinal.config.*;
import com.jfinal.index.IndexController;
import com.jfinal.kit.PropKit;
import com.jfinal.login.LoginController;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class JfinalConfig extends JFinalConfig{
    public void configConstant(Constants constants) {
//        constants.setDevMode(false);
        PropKit.use("common.properties");
    }

    public void configRoute(Routes routes) {
        routes.add("/index", IndexController.class,"/index");
        routes.add("/", LoginController.class,"/login");

    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins me) {
        // 配置 druid 数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 MappingKit 中自动化搞定
//        _MappingKit.mapping(arp);
        me.add(arp);

    }
    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
