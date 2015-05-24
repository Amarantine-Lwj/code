package cn.cultivator.bbs.domain;

public class Type {
	private Integer id;
	private String name;
	private String imagepath;
	private Integer click;
	private Integer admin_id;
	private Admin admin;
	private Integer topicNum;
	private Topic newTopic;
	

	public Topic getNewTopic() {
		return newTopic;
	}
	public void setNewTopic(Topic newTopic) {
		this.newTopic = newTopic;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Integer getTopicNum() {
		return topicNum;
	}
	public void setTopicNum(Integer topicNum) {
		this.topicNum = topicNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}


}
