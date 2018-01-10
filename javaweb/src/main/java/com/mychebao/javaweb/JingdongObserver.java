/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: JingdongObserver.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhangdanji
 */
public class JingdongObserver implements Observer {

    public void update(Observable o, Object arg) {
        String newProduct = (String)arg;
        System.out.println("京东添加新产品:" + newProduct);
    }
}

class TaobaoObserver implements Observer{

    public void update(Observable o, Object arg) {
        String newProduct = (String)arg;
        System.out.println("淘宝添加新产品:" + newProduct);
    }
}
