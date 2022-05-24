package model;

public class Account {
	private String status;
	private String name;
	private AppStore store;
	private String[] namesOfDownloadedApps;
	private int noda; // number of downloaded apps
	
	
	public Account(String name,AppStore appStore) {
		this.name = name;
		this.store = appStore;
		
		this.namesOfDownloadedApps = new String[50];
		this.noda=0;
		this.status=String.format("An account linked to the %s store is created for %s.",
				appStore.getBranch(),
				name);
}
	public void submitRating(String nameOfApp,int score) {
		boolean found = false;
		for(int i=0;i<this.noda&&!found;i++) {
			if(this.namesOfDownloadedApps[i].equals(nameOfApp)) {
				found = true;
			}
		}
		if(found!=true) {
		this.status=String.format("Error: %s is not a downloaded app for %s.",
				nameOfApp,
				this.name);
		}
		else {
			this.getApp(nameOfApp).submitRating(score);
			this.status = String.format("Rating score %d of %s is successfully submitted for %s.", 
					score,
					this.name,
					nameOfApp);
			
		}
	}
	public void switchStore(AppStore store) {
		this.store = store;
		this.status = String.format("Account for %s is now linked to the %s store.", 
				this.name,
				this.store.getBranch());
	}
	public void uninstall(String nameOfApp) {
		// check to see if nameofApp is the name of a downloaded app.
		//if non-existing, do nothing.
		// if existing, remove the app.
		
		// initially, when an account is first created, no apps have been downloaded,
		// so therefore nothing can be unistalled.
		boolean found = false;
		for(int i=0;i<this.noda&&!found;i++) {
			if(this.namesOfDownloadedApps[i].equals(nameOfApp)) {
				found = true;
			}
		}
		if(found!=true) {
		this.status=String.format("Error: %s has not been downloaded for %s.",
				nameOfApp,
				this.name);
		}
		else {
			//GoodNotes 5 is successfully uninstalled for Suyeon.
			for(int i=0;i<this.noda;i++) {
				if(this.namesOfDownloadedApps[i].equals(nameOfApp)) {
					String temp;
					for(int j=i;j<this.noda;j++) {
						temp = this.namesOfDownloadedApps[j];
						this.namesOfDownloadedApps[j] = this.namesOfDownloadedApps[j+1];
						this.namesOfDownloadedApps[j+1]=temp;
						
					}
					this.namesOfDownloadedApps[this.noda]=null;
					this.noda--;
					break;
				}
				
			}
			this.status=String.format("%s is successfully uninstalled for %s.",
					nameOfApp,
					this.name);
		}
	}
	public String[] getNamesOfDownloadedApps() {
		String[] nda = new String[this.noda];
		for(int i=0;i<noda;i++) {
		 nda[i] = this.namesOfDownloadedApps[i];
		}
		
		
		return nda;
	}
	public App[] getObjectsOfDownloadedApps() {
		App[] dApps= new App[this.noda];
		for(int i=0;i<this.noda;i++) {
			String nameOfApp= this.namesOfDownloadedApps[i];
			App app=this.getApp(nameOfApp);
			
		 dApps[i] = app;
		}
		
		
		return dApps;
	}
	private App getApp(String namOfApp) {
		return this.store.getApp(namOfApp);
		
	}
	
	public String toString() {
		return this.status;
	}
	public void download(String nameOfApp) {
		boolean check=false;
		for(int i=0;i<this.noda;i++) {
			if(this.namesOfDownloadedApps[i].equals(nameOfApp))
			{
				check=true;
			}
		}
		if(check==true) {
			//Error: Things 3 for iPad has already been downloaded for Heeyeon.
			this.status=String.format("Error: %s has already been downloaded for %s.",
					nameOfApp,
					this.name);
		}
		else {
		this.namesOfDownloadedApps[this.noda] = nameOfApp;
		noda++;
		this.status=String.format("%s is successfully downloaded for %s.",
				nameOfApp,
				this.name);
		}
	}
	

}





