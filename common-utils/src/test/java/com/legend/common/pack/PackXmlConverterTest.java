package com.legend.common.pack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.legend.common.pack.PackXmlConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class PackXmlConverterTest {
	
	private static final String xmlString = ""
			+ "<books>"
			+ "	<book price=\"108\">"
			+ "		<name>Java编程思想</name>"
			+ "		<author>Bruce Eckel</author>"
			+ "	</book>"
			+ "	<book price=\"52\">"
			+ "		<name>Effective Java</name>"
			+ "		<author>Joshua Bloch</author>"
			+ "	</book>"
			+ "	<book price=\"118\">"
			+ "		<name>Java 7入门经典</name>"
			+ "		<author>Ivor Horton</author>"
			+ "	</book>"
			+ "</books>";

	@Test
	public void testToBean(){
		Books books = PackXmlConverter.toBean(xmlString, Books.class);
		System.out.println(books.toString());
	}
	@Test
	public void testToXml(){
		Books books = new Books();
		books.setList(new ArrayList<Book>());
		Book book1 = new Book();
		book1.setName("effective java -1");
		book1.setAuthor("zyw - 1");
		book1.setPrice("1.1");
		books.getList().add(book1);
		Book book2 = new Book();
		book2.setName("effective java -2");
		book2.setAuthor("zyw - 2");
		book2.setPrice("1.2");
		books.getList().add(book2);
		System.out.println(PackXmlConverter.toXml(books));
	}
}

@XStreamAlias("books")
class Books {

    // 隐式集合，加上这个注解可以去掉book集合最外面的<list></list>这样的标记
    @XStreamImplicit
    private List<Book> list;

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Books [list=" + list + "]";
	}
	
	

}

@XStreamAlias("book")
class Book {

    // 别名注解，这个别名就是XML文档中的元素名，Java的属性名不一定要与别名一致
    @XStreamAlias("name")
    private String name;
    
    @XStreamAlias("author")
    private String author;
    
    // 属性注解，此price就是book的属性，在XML中显示为：<book price="108">
    @XStreamAsAttribute()
    @XStreamAlias("price")
    private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	

}
