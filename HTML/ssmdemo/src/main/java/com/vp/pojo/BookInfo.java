package com.vp.pojo;

import java.util.Date;

public class BookInfo {
    private String bookCode;

    private String bookName;

   /* private Integer bookType;*/
   private   BookType  bookType;

    private String bookAuthor;

    private String publishPress;

    private Date publishDate;

    private Integer isBorrow=0;

    private String imagepath;


    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode == null ? null : bookCode.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }



    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress == null ? null : publishPress.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Integer isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType=" + bookType +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishPress='" + publishPress + '\'' +
                ", publishDate=" + publishDate +
                ", isBorrow=" + isBorrow +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}