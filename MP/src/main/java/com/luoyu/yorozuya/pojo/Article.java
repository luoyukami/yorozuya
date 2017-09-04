package com.luoyu.yorozuya.pojo;

/**
 * 文章POJO类，包含文章的基本数据
 *
 * @author ganxiang20970
 *         2017-08-26 21:24
 */
public class Article {

    private String title;//文章标题
    private String tag;//文章标签
    private String content;//文章内容

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    /**
     * 判断文章对象是否为空
     * @return true：空；false：非空
     * 备注：只判断必备属性是否满足，主要用于提交表单时的判断
     */
    public boolean isEmpty(){
        return this.content.isEmpty() && this.title.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
