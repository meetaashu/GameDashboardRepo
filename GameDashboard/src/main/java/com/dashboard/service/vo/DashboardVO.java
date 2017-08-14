package com.dashboard.service.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author aashuGupta
 *
 */

@XmlRootElement(name="Dashboard")
public class DashboardVO {
private String minute;
private String name;

public String getMinute() {
	return minute;
}
public void setMinute(String minute) {
	this.minute = minute;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
