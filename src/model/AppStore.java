package model;

public class AppStore {

	private String branch;
	private App[] apps;
	private int noa;
	private int maxNumberOfBranch;
	public AppStore(String branch, int i) {
		this.branch = branch;
		this.maxNumberOfBranch = i;
		this.apps = new App[i];
		this.noa=0;

	}
	public String getBranch() {
		return this.branch;
	}
	public App getApp(String app) {
		App result=null;
		for(int i = 0;i<this.noa;i++) {
			if(this.apps[i].getName().equals(app)) {
				result= this.apps[i];
			}

		}
		return result;
	}
	public String[] getStableApps(int numberOfUpdates) {
		String[] stableApps = new String[this.noa];
		int count =0;
		for(int i=0;i<this.noa;i++) {
			App app = this.apps[i];
			if(app.getUpdateHistory().length>=numberOfUpdates) {

				//GoodNotes 5 (3 versions; Current Version: Version 5.7.31 contains 1 fixes [Better logging])


				stableApps[count] = String.format("%s (%d versions; Current Version: %s)", 
						app.getName(),
						app.getUpdateHistory().length,
						app.getWhatIsNew());
				count++;
			}
		}
		String[] stableAppsPrecise = new String[count];
		for(int i=0;i<count;i++) {
			stableAppsPrecise[i] = stableApps[i];
		}
		return stableAppsPrecise;


	}
	public void addApp(App app) {
		this.apps[this.noa] = app;
		this.noa++;
	}


}
