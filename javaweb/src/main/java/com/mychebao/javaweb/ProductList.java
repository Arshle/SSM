/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ProductList.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author zhangdanji
 */
public class ProductList extends Observable {

    private List<String> productList = null;

    private static ProductList instance;

    private ProductList(){}

    public static ProductList getInstance(){
        if(instance == null){
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增了产品:" + newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }

    public static void main(String[] args) {
        ProductList observable = ProductList.getInstance();
        TaobaoObserver taobao = new TaobaoObserver();
        JingdongObserver jingdong = new JingdongObserver();
        observable.addProductListObserver(taobao);
        observable.addProductListObserver(jingdong);
        observable.addProduct("IphoneX");
    }
}
