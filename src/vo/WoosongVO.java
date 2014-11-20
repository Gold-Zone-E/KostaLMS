package vo;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

//create table woosong(
//num number primary key,
//writer varchar2(20),
//password varchar2(20),
//sub varchar2(100),
//content varchar2(200),
//wfile blob);
//commit;

public class WoosongVO {
	private int num;
	private String writer, password, sub, content, file_path;
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	private MultipartFile wfile;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getWfile() {
		return wfile;
	}
	public void setWfile(MultipartFile wfile) {
		this.wfile = wfile;
	}	
}
