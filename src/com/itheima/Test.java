package com.itheima;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Book(name="唐诗",authors = {"李白","杜甫"})
public class Test{



    @Book(name="saadasd",authors = {"asd三","6778asd"})
    private String name;

    @Book(name="十万个为什么",authors = {"张三","李四"})
    public void getName(){
        System.out.println();
        List<? super Number> list1 = new ArrayList<>();
        List<? super T2> list2 = new ArrayList<>();
        List<? super T3> list3 = new ArrayList<>();

        list1.add(2.3);
        list2.add(new T2());
        list3.add(new T3());
    }

    @Book(name="辣鸡队友",authors = {"郭艾伦","周琦"})
    public Test(){};

    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.itheima.Test");
        Book book = (Book)aClass.getAnnotation(Book.class);
        System.out.println(book.name() + ".." + book.price());

        Field declaredFields = aClass.getDeclaredField("name");
        Book annotation = declaredFields.getAnnotation(Book.class);
        System.out.println(annotation.name() + ".." + annotation.price());
        List<? extends Number> list1 = new ArrayList<>();
        List<? extends Long> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();


    }

    public static void f(List<? extends String> list) { }
}

class T{};

class T2 extends T{};

class T3 extends T2{};