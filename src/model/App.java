package model;

public class App {
	private String Name;
	private int maxNumberOfRatings;
	private int [] ratings;
	private int nor;
	private Log[] updates;
	private int nou;
	private final int MAX_NUM_OF_UPDATES=20;
	

	public App(String name, int maxNumberOfRatings){
		this.Name = name;
		this.updates = new Log[MAX_NUM_OF_UPDATES];
		this.nou = 0;
		this.maxNumberOfRatings = maxNumberOfRatings;
		this.ratings = new int[maxNumberOfRatings];
		this.nor=0;
	}
	public String getName() {
		return this.Name;
	}
	
	
	public void releaseUpdate(String version) {
		Log nu = new Log(version);
		this.updates[this.nou] = nu;
		this.nou++;
	}
	public String getWhatIsNew() {
		String s="";
		if(this.nou==0) {
			s = "n/a";
		}
		else {
			s= this.updates[this.nou-1].toString();
		}

		return s;
	}
	public Log[] getUpdateHistory() {
		Log[] log = new Log[this.nou];
		for(int i=0; i<this.nou;i++) {
			log[i] = this.updates[i];
		}
		
		return log;
	}
	public Log getVersionInfo(String version) {
		Log result=null;
		boolean foundmatch=false;
		for(int i = 0;i<this.nou&&!foundmatch;i++) {
			if(this.updates[i].getVersion().equals(version)) {
				result= this.updates[i];
				foundmatch=true;
			}
			
		}
		return result;
		
	}
	public String getRatingReport() {
		String result;
		int s1=0,s2=0,s3=0,s4=0,s5=0;
		int sum=0;
		double avg;
		if(this.nor==0) {
			result = "No ratings submitted so far!";
		}
		else {
			for(int i=0;i<this.nor;i++) {
				sum+=this.ratings[i];
				
				if(this.ratings[i]==1) {
					s1++;
				}
				else if(this.ratings[i]==2) {
					s2++;
				}
				else if(this.ratings[i]==3) {
					s3++;
				}
				else if(this.ratings[i]==4) {
					s4++;
				}
				else if(this.ratings[i]==5) {
					s5++;
				}
				
			}
			double av = (double) sum;
			avg = av/this.nor;
			result = String.format("Average of %d ratings: %.1f (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)",
					this.nor,
					avg,
					s5,
					s4,
					s3,
					s2,
					s1);
		
		}
		return result;
	}
	public String toString() {
		int sum=0;
		double avg;
		String result;
		if(this.nor==0) {
			result = String.format("%s (Current Version: %s; Average Rating: n/a)",
					this.Name,
					this.getWhatIsNew());
		}
		else {
		for(int i=0;i<this.nor;i++) {
			sum+=this.ratings[i];
		}
		double av = (double) sum;
		avg = av/this.nor;
		result= String.format("%s (Current Version: %s; Average Rating: %.1f)",
				this.Name,
				this.getWhatIsNew(),
				avg);
		}
		return result;
	}
	public void submitRating(int i) {
		this.ratings[this.nor]=i;
		nor++;
		
	}
	
}
