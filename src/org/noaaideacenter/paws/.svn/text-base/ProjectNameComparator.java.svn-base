package org.noaaideacenter.paws;

import java.util.Comparator;

public class ProjectNameComparator implements Comparator<ProjectBean> {

	public ProjectNameComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(ProjectBean p1bean, ProjectBean p2bean)
	{
		/*
		ProjectBean p1bean = (ProjectBean) p1;
		ProjectBean p2bean = (ProjectBean) p2;
		*/
		
		String p1name = p1bean.getProjectNameStripURL();
		String p2name = p2bean.getProjectNameStripURL();
		
		return p1name.compareToIgnoreCase(p2name);
	}
	
}
